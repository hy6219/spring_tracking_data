package com.example.spring_boot_2d_data.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Slf4j
@Service
public class DataServiceImpl implements DataService{

    private final String apiKey = "E7CC71E8-7489-390F-82FE-AC464EC56463";

    @Override
    public String testResponse() {
        String baseUrl = "http://api.vworld.kr/req/data";

        /*
         http://api.vworld.kr/req/data?service=data&request=GetFeature&data=LT_L_TRKROAD&key=인증키&domain=인증키 URL&[요청파라미터]
         https://dev.vworld.kr/proxy.do?url=http%3A%2F%2Fapi.vworld.kr%2Freq%2Fdata%3Fservice%3Ddata%26version%3D2.0%26request%3DGetFeature%26key%3D483E0418-2F46-3223-80A1-F66D16A24685%26format%3Dxml%26errorformat%3Dxml%26size%3D10%26page%3D1%26data%3DLT_L_TRKROAD%26geomfilter%3DLINESTRING(14134884.636509%25204495590.331047%252C14135111.558936%25204495559.2785043)%26attrfilter%3Dcat_nam%253A%253D%253A%25EB%2591%2598%25EB%25A0%2588%25EA%25B8%25B8%25EB%25A7%2581%25ED%2581%25AC%26columns%3Dcat_nam%252Clnk_nam%252Ccos_num%252Ccos_nam%252Ccos_lvl%252Clen_tim%252Cleng_lnk%252Ccomment%252Cag_geom%26geometry%3Dtrue%26attribute%3Dtrue%26crs%3DEPSG%253A900913%26domain%3Dapi.vworld.kr
         */
        URI uri = UriComponentsBuilder.fromUriString(baseUrl)
                .queryParam("service","data")
                .queryParam("request","GetFeature")
                .queryParam("data","LT_L_TRKROAD")
                .queryParam("key",apiKey)
                .queryParam("geomFilter","BOX(14134884.636509,4495590.331047,14135111.558936,4495559.2785043)")
                .queryParam("crs","EPSG:900913")
                .build()
                .toUri();

        System.out.println("uri : "+uri);
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(uri,String.class);

    }
}
