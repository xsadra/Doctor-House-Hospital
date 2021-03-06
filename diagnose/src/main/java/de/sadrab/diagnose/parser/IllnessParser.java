package de.sadrab.diagnose.parser;


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
public class IllnessParser {
    private final ResourceLoader resourceLoader;

    public IllnessParser(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    public Map<String, List<String>> getIllnesses() {
        Map<String, List<String>> map = new HashMap<>();
        Resource resource = resourceLoader.getResource("classpath:symptoms.txt");
        try {
            Files.lines(resource.getFile().toPath())
                    .map(line -> line.split(";"))
                    .forEach(e -> map.put(e[0], Arrays.asList(e[1].split(","))));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return map;
    }
}