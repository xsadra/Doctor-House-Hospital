package de.sadrab.accountancy.parser;


import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
//@RequiredArgsConstructor
public class IllnessCost {
    private final ResourceLoader resourceLoader;

    public IllnessCost(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    public Map<String, Double> getCost() {
        Map<String, Double> map = new HashMap<>();
        Resource resource = resourceLoader.getResource("classpath:cost.txt");
        try {
            Files.lines(resource.getFile().toPath())
                    .map(line -> line.split(";"))
                    .forEach(e -> map.put(e[0], Double.parseDouble(e[1])));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return map;
    }
}