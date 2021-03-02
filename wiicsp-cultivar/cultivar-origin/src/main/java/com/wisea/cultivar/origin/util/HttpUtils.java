package com.wisea.cultivar.origin.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.text.MessageFormat;
import java.util.List;
import java.util.Map;

import com.wisea.cloud.common.constants.ConstantError;
import com.wisea.cloud.common.exception.BusinessException;


/**
 * http请求工具类
 *
 * @author LiQ
 *
 */
public class HttpUtils
{
	// 连接超时时间
	private static final int CONNECTION_TIMEOUT = 3000;
	// 参数编码
	private static final String ENCODE_CHARSET = "utf-8";
	/**
	 * HttpURLConnection通用类
	 *
	 * @param strUrl
	 *            链接地址
	 * @param param
	 *            请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
	 * @return
	 */
	@SuppressWarnings("finally")
	public static String connect(String strUrl, String param)
	{
		String result = "";
		HttpURLConnection httpConn = null;
		OutputStream os = null;
		OutputStreamWriter osw = null;
		try
		{

			URL url = new URL(strUrl);
			httpConn = (HttpURLConnection) url.openConnection();
			HttpURLConnection.setFollowRedirects(true);
			httpConn.setDoOutput(true);
			httpConn.setRequestMethod("POST");
			httpConn.setRequestProperty("Content-Type", "text/html");
			// 设置连接超时时间
			httpConn.setConnectTimeout(15000);
			// 设置读取超时时间
			httpConn.setReadTimeout(15000);
			httpConn.connect();
			os = httpConn.getOutputStream();
			osw = new OutputStreamWriter(os);
			osw.write(param.toCharArray(), 0, param.length());
			osw.flush();
			// 读取响应数据
			int code = httpConn.getResponseCode();
			if (httpConn.getConnectTimeout() == 0)
			{
				throw ConstantError.BUS_903;
			}
			// 是否正常响应
			if (code == 200)
			{
				String sCurrentLine = "";

				// 读取响应数据
				InputStream is = httpConn.getInputStream();
				BufferedReader reader = new BufferedReader(
						new InputStreamReader(is));
				while ((sCurrentLine = reader.readLine()) != null)
				{
					if (sCurrentLine.length() > 0)
					{
						result = result + sCurrentLine.trim();
					}
				}
				is.close();
			}
			else
			{
				throw new BusinessException(ConstantError.ERR_999, "远程请求错误");
			}
		}
		catch (Exception e)
		{
			throw new BusinessException(ConstantError.ERR_999, "远程请求错误");
		}
		finally
		{
			if (osw != null && os != null && httpConn != null)
			{
				try
				{
					// 关闭流
					osw.close();
					os.close();
				}
				catch (final IOException e)
				{
					e.printStackTrace();
				}
				// 断开连接
				httpConn.disconnect();
			}
			return result;
		}
	}

	/**
	 * HttpURLConnection通用类
	 *
	 * @param strUrl
	 *            链接地址
	 * @param param
	 *            请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
	 * @return
	 */
	@SuppressWarnings("finally")
	public static String connectJson(String strUrl, String param)
	{
		String result = "";
		HttpURLConnection httpConn = null;
		OutputStream os = null;
		OutputStreamWriter osw = null;
		try
		{

			URL url = new URL(strUrl);
			httpConn = (HttpURLConnection) url.openConnection();
			HttpURLConnection.setFollowRedirects(true);
			httpConn.setDoOutput(true);
			httpConn.setRequestMethod("POST");
			httpConn.setRequestProperty("Content-Type", "application/json");
			// 设置连接超时时间
			httpConn.setConnectTimeout(15000);
			// 设置读取超时时间
			httpConn.setReadTimeout(15000);
			httpConn.connect();
			os = httpConn.getOutputStream();
			osw = new OutputStreamWriter(os);
			osw.write(param.toCharArray(), 0, param.length());
			osw.flush();
			// 读取响应数据
			int code = httpConn.getResponseCode();
			if (httpConn.getConnectTimeout() == 0)
			{
				throw ConstantError.BUS_903;
			}
			// 是否正常响应
			if (code == 200)
			{
				String sCurrentLine = "";

				// 读取响应数据
				InputStream is = httpConn.getInputStream();
				BufferedReader reader = new BufferedReader(
						new InputStreamReader(is));
				while ((sCurrentLine = reader.readLine()) != null)
				{
					if (sCurrentLine.length() > 0)
					{
						result = result + sCurrentLine.trim();
					}
				}
				is.close();
			}
			else
			{
				throw new BusinessException(ConstantError.ERR_999, "远程请求错误");
			}
		}
		catch (Exception e)
		{
			throw new BusinessException(ConstantError.ERR_999, "远程请求错误");
		}
		finally
		{
			if (osw != null && os != null && httpConn != null)
			{
				try
				{
					// 关闭流
					osw.close();
					os.close();
				}
				catch (final IOException e)
				{
					e.printStackTrace();
				}
				// 断开连接
				httpConn.disconnect();
			}
			return result;
		}
	}

	/**
     * 向指定URL发送GET方法的请求
     *
     * @param url
     *            发送请求的URL
     * @param param
     *            请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
     * @return URL 所代表远程资源的响应结果
     */
    public static String sendGet(String url, String param) {
        String result = "";
        BufferedReader in = null;
        try {
            String urlNameString = url + "?" + param;
            URL realUrl = new URL(urlNameString);
            // 打开和URL之间的连接
            URLConnection connection = realUrl.openConnection();
            // 设置通用的请求属性
            connection.setRequestProperty("accept", "*/*");
            connection.setRequestProperty("connection", "Keep-Alive");
            connection.setRequestProperty("user-agent",
                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            // 建立实际的连接
            connection.connect();
            // 获取所有响应头字段
            Map<String, List<String>> map = connection.getHeaderFields();
            // 遍历所有的响应头字段
            for (String key : map.keySet()) {
                System.out.println(key + "--->" + map.get(key));
            }
            // 定义 BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(
                    connection.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
        	throw new BusinessException(ConstantError.ERR_909, MessageFormat.format(ConstantError.MSG_909, e.getMessage()));
        }
        // 使用finally块来关闭输入流
        finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return result;
    }
    /**
	 * 发送HTTP_GET请求
	 *
	 * @see 本方法默认的连接和读取超时均为30秒
	 * @param httpUrl
	 *            请求地址
	 * @param map
	 *            发送到远程主机的正文数据[a:1,b:2]
	 * @return String
	 */
	public static String getRequest(String httpUrl, String... params) {
		StringBuilder resultData = new StringBuilder();
		URL url = null;
		try {
			String paramurl = sendGetParams(httpUrl, params);
			url = new URL(paramurl);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		HttpURLConnection urlConn = null;
		InputStreamReader in = null;
		BufferedReader buffer = null;
		String inputLine = null;
		if (url != null) {
			try {
				urlConn = (HttpURLConnection) url.openConnection();
				urlConn.setRequestMethod("GET");
				urlConn.setConnectTimeout(CONNECTION_TIMEOUT);
				in = new InputStreamReader(urlConn.getInputStream(), HttpUtils.ENCODE_CHARSET);
				buffer = new BufferedReader(in);
				if (urlConn.getResponseCode() == 200) {
					while ((inputLine = buffer.readLine()) != null) {
						resultData.append(inputLine);
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					if (buffer != null) {
						buffer.close();
					}
					if (in != null) {
						in.close();
					}
					if (urlConn != null) {
						urlConn.disconnect();
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return resultData.toString();
	}
	/**
	 * Get追加参数
	 *
	 * @see <code>params</code>
	 * @param reqURL
	 *            请求地址
	 * @param params
	 *            发送到远程主机的正文数据[a:1,b:2]
	 * @return
	 */
	private static String sendGetParams(String reqURL, String... params) {
		StringBuilder sbd = new StringBuilder(reqURL);
		if (params != null && params.length > 0) {
			if (isexist(reqURL, "?")) {// 存在?
				sbd.append("&");
			} else {
				sbd.append("?");
			}
			for (int i = 0; i < params.length; i++) {
				String[] temp = params[i].split(":");
				sbd.append(temp[0]);
				sbd.append("=");
				sbd.append(urlEncode(temp[1]));
				sbd.append("&");
			}
			sbd.setLength(sbd.length() - 1);// 删掉最后一个
		}
		return sbd.toString();
	}

	// 查找某个字符串是否存在
	private static boolean isexist(String str, String fstr) {
		return str.indexOf(fstr) == -1 ? false : true;
	}

	/**
	 * 编码
	 *
	 * @param source
	 * @return
	 */
	private static String urlEncode(String source) {
		String result = source;
		try {
			result = java.net.URLEncoder.encode(source, HttpUtils.ENCODE_CHARSET);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return result;
	}
}
