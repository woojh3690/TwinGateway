package kr.co.iwaz;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

public class Main {

    public static void main(String[] args) throws Exception {
        System.out.println("TwinGateway starting...");

        // 환경 설정 폴더 경로
        String confPath = (args.length == 1) ? args[0] : "./conf/twin_gateway.conf";
        Properties prop = getProperties(confPath);
        new Worker(prop).run();

        System.out.println("End program");
    }

    /**
     * 설정 파일 읽기
     * @param propPath  설정파일 경로
     * @return 초기화된 Properties 객체
     * @throws IOException 파일이 없는 경우
     */
    public static Properties getProperties(String propPath) throws IOException {
        FileInputStream fs = new FileInputStream(propPath);
        Properties prop = new Properties();
        prop.load(new InputStreamReader(fs, StandardCharsets.UTF_8));
        return prop;
    }
}
