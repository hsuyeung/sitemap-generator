package com.hsuyeung.demo;

import com.hsuyeung.sitemap.ChangeFreqEnum;
import com.hsuyeung.sitemap.SitemapGenerator;
import com.hsuyeung.sitemap.URLNode;
import lombok.SneakyThrows;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author hsuyeung
 * @date 2023/11/10
 */
public class Demo {
    @SneakyThrows
    public static void main(String[] args) {
        // 模拟生成十条数据
        LocalDateTime now = LocalDateTime.now();
        List<URLNode> urlNodes = IntStream.rangeClosed(1, 10)
                .mapToObj(idx -> URLNode.builder()
                        .loc("https://www.hsuyeung.com/article/link" + 1)
                        .lastMod(now)
                        .changeFreq(ChangeFreqEnum.WEEKLY)
                        .priority(0.85)
                        .build())
                .collect(Collectors.toList());
        SitemapGenerator.generate(urlNodes, "./sitemap.xml");
    }
}
