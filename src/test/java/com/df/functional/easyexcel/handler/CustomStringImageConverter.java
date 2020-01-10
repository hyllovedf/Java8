package com.df.functional.easyexcel.handler;

import com.alibaba.excel.converters.string.StringImageConverter;
import com.alibaba.excel.metadata.CellData;
import com.alibaba.excel.metadata.GlobalConfiguration;
import com.alibaba.excel.metadata.property.ExcelContentProperty;
import com.alibaba.excel.util.IoUtils;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.Files;
import java.util.Objects;

/**
 * @author hanyli
 * @date 2020/1/10
 */
public class CustomStringImageConverter extends StringImageConverter {
    @Override
    public CellData convertToExcelData(String value, ExcelContentProperty contentProperty, GlobalConfiguration globalConfiguration) throws IOException {
        return new CellData(getByteArray(value));
    }

    private byte[] getByteArray(String url) throws IOException {
        InputStream in = getInputStream(url);
        if (Objects.nonNull(in)) {
            byte[] var4;
            try {
                int fileLength = in.available();
                var4 = fileLength > 0L ? IoUtils.toByteArray(in, fileLength) : IoUtils.toByteArray(in);

            } finally {
                System.in.close();
            }
            return var4;
        }
        return null;
    }

    private InputStream getInputStream(String url) {
        try {
            HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
            connection.setReadTimeout(5000);
            connection.setConnectTimeout(5000);
            connection.setRequestMethod("GET");
            if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                return connection.getInputStream();
            }
        } catch (IOException e) {
            System.out.println("获取网络图片出现异常，图片路径为：" + url);
            e.printStackTrace();
        }
        return null;
    }
}
