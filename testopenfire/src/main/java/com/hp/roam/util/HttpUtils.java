package com.hp.roam.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import com.fasterxml.jackson.databind.ObjectMapper;

public class HttpUtils {

	public static final Logger logger = LoggerFactory.getLogger(HttpUtils.class);

	public static final ObjectMapper mapper = new ObjectMapper();
	/**
	 * 设置上网代理
	 */
	public static HttpHost proxy = new HttpHost("web-proxy.cn.hpicorp.net", 8080, "http");

//	public static final RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(60000)
//			.setSocketTimeout(60000).setConnectionRequestTimeout(10000).setProxy(proxy).build();

	 public static final RequestConfig requestConfig =
	 RequestConfig.custom().setConnectTimeout(60000).setSocketTimeout(60000).setConnectionRequestTimeout(10000).build();

	public static void getPic(String url, String filePath) {

		logger.info("HttpUtils.getFile start......");
		CloseableHttpClient client = HttpClients.createDefault();
		CloseableHttpResponse response = null;

		HttpGet get = new HttpGet(url);
		get.setConfig(requestConfig);
		InputStream in = null;
		OutputStream out = null;
		try {
			response = client.execute(get);
			HttpEntity entity = response.getEntity();
			in = entity.getContent();

			long length = entity.getContentLength();
			if (length <= 0) {
				logger.info("下载文件不存在！");
			}

			File file = new File(filePath);
			if (!file.exists()) {
				file.createNewFile();
			}

			out = new FileOutputStream(file);
			byte[] buffer = new byte[4096];
			int readLength = 0;
			while ((readLength = in.read(buffer)) > 0) {
				byte[] bytes = new byte[readLength];
				System.arraycopy(buffer, 0, bytes, 0, readLength);
				out.write(bytes);
			}

			out.flush();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (out != null) {
				try {
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (response != null) {
				try {
					response.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (client != null) {
				try {
					client.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			logger.info("HttpUtils.getFile ended......");
		}
	}

	/**
	 * 上传文件 带参数
	 * 
	 * @return
	 */
	@SuppressWarnings("deprecation")
	public static String postFile(File file, Map<String, String> params, String uploadUrl) {
		CloseableHttpClient client = HttpClients.createDefault();
		CloseableHttpResponse response = null;
		HttpPost post = new HttpPost(uploadUrl);
		HttpEntity reqEntity = null;
		post.setConfig(requestConfig);
		FileBody fileBody = new FileBody(file);
		MultipartEntityBuilder builder = MultipartEntityBuilder.create();
		builder.addPart("file", fileBody);
		try {
			// 循环将params 加入到参数中
			Set<Entry<String, String>> ketSet = params.entrySet();
			for (Iterator<Entry<String, String>> iterator = ketSet.iterator(); iterator.hasNext();) {
				Entry<String, String> entry = (Entry<String, String>) iterator.next();
				if(!StringUtils.isEmpty(entry.getKey())){
					StringBody comment = new StringBody((String) entry.getValue(), Charset.forName("UTF-8"));
					builder.addPart((String) entry.getKey(), comment);
				}
			}
			reqEntity = builder.build();
			post.setEntity(reqEntity);
			response = client.execute(post);
			String result = EntityUtils.toString(response.getEntity());
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (client != null) {
				try {
					client.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (response != null) {
				try {
					response.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}

	/**
	 * get方法 获取
	 * 
	 * @return
	 */
	public static String get(List<NameValuePair> params, String url) {
		CloseableHttpClient client = HttpClients.createDefault();
		CloseableHttpResponse response = null;
		try {
			String str = EntityUtils.toString(new UrlEncodedFormEntity(params, Consts.UTF_8));
			logger.info("the param is" + str);
			HttpGet get = new HttpGet(url + "?" + str);
			get.setConfig(requestConfig);
			response = client.execute(get);
			String result = EntityUtils.toString(response.getEntity());
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * post方式提交数据 form表单形式提交
	 * 
	 * @return
	 */
	public static String post(List<NameValuePair> params, String url) {
		CloseableHttpClient client = HttpClients.createDefault();
		CloseableHttpResponse response = null;
		HttpPost post = new HttpPost(url);
		post.setConfig(requestConfig);
		try {
			HttpEntity reqEntity = new UrlEncodedFormEntity(params);
			post.setEntity(reqEntity);
			response = client.execute(post);
			String result = EntityUtils.toString(response.getEntity());
			logger.info("the method post result is -------" + result);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * use json params to post 
	 * @param params
	 * @param url
	 * @return
	 */
	public static String postJson(String params, String url) {
		CloseableHttpClient client = HttpClients.createDefault();
		CloseableHttpResponse response = null;
		HttpPost post = new HttpPost(url);
		post.setConfig(requestConfig);
		try {
			HttpEntity reqEntity = new StringEntity(params, "UTF-8");
			post.setHeader("Content-type", "application/json");
			post.setEntity(reqEntity);
			response = client.execute(post);
			String result = EntityUtils.toString(response.getEntity());
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * put方式 提交数据
	 * 
	 * @param params
	 * @param url
	 * @return
	 */
	public static String put(String params, String url) {
		CloseableHttpClient client = HttpClients.createDefault();
		CloseableHttpResponse response = null;
		HttpPut put = new HttpPut(url);
		put.setConfig(requestConfig);
		try {
			HttpEntity reqEntity = new StringEntity(params, "UTF-8");
			put.setHeader("Content-type", "application/json");
			put.setEntity(reqEntity);
			response = client.execute(put);
			String result = EntityUtils.toString(response.getEntity());
			logger.info("the method put result is -------" + result);
			Integer status = response.getStatusLine().getStatusCode();
			return String.valueOf(status);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 获取网页内容
	 * @param url
	 * @return
	 */
	public static String getContent(String url){
		CloseableHttpClient client = HttpClients.createDefault();
		CloseableHttpResponse response = null;

		HttpGet get = new HttpGet(url);
		get.setConfig(requestConfig);
		try {
			response = client.execute(get);
			String result = EntityUtils.toString(response.getEntity());
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if (response != null) {
				try {
					response.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (client != null) {
				try {
					client.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}
}
