package ftn.sbzn.PoEhelperbackend.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import ftn.sbzn.PoEhelperbackend.dto.*;
import ftn.sbzn.PoEhelperbackend.mapper.DataMapper;
import ftn.sbzn.PoEhelperbackend.model.Keystone;
import ftn.sbzn.PoEhelperbackend.model.ModList;
import ftn.sbzn.PoEhelperbackend.model.Mods;
import ftn.sbzn.PoEhelperbackend.model.SkillGem;
import ftn.sbzn.PoEhelperbackend.service.KeystoneService;
import ftn.sbzn.PoEhelperbackend.service.ModsService;
import ftn.sbzn.PoEhelperbackend.service.SequenceGeneratorService;
import ftn.sbzn.PoEhelperbackend.service.SkillGemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/data")
public class DataCollectController {

    @Autowired
    SkillGemService skillGemService;

    @Autowired
    SequenceGeneratorService sequenceGeneratorService;

    @Autowired
    KeystoneService keystoneService;

    DataMapper mapper;

    @Autowired
    private ModsService modsService;


    public DataCollectController() {
        mapper = new DataMapper();
    }

    private final HttpClient httpClient = HttpClient.newBuilder()
            .version(HttpClient.Version.HTTP_2)
            .build();


    @GetMapping("/skillGems")
    public ResponseEntity<?> getSkillGemData() {
        HttpRequest request = HttpRequest.newBuilder().GET()
                .uri(URI.create("https://pathofexile.fandom.com/api.php?action=cargoquery&tables=items,skill_gems&join_on=items._pageID=skill_gems._pageID&fields=items.name,items.class_id,skill_gems.gem_tags&where=items.frame_type=%22gem%22&limit=max&format=json"))
                .build();
        try {
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            ObjectMapper mapper = new ObjectMapper();
            SkillGemsDataDTO data = mapper.readerFor(SkillGemsDataDTO.class).readValue(response.body());
            for (SkillGemDataWrapper gemWrapper: data.getAllGemData()) {
                String[] tags = gemWrapper.getGemDataDTO().getGemTags().split(",");
                SkillGem gem = new SkillGem(
                        sequenceGeneratorService.generateSequence(SkillGem.SEQUENCE_NAME),
                        gemWrapper.getGemDataDTO().getName(),
                        gemWrapper.getGemDataDTO().getClassId(),
                        Arrays.asList(tags));
                skillGemService.save(gem);
            }
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/saveKeystones")
    public ResponseEntity<?> getKeystonesData() {
        HttpRequest request = HttpRequest.newBuilder().GET()
                .uri(URI.create("https://pathofexile.fandom.com/api.php?action=cargoquery&tables=passive_skills&fields=name&where=is_keystone=true&limit=max&format=json"))
                .build();
        try {
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            ObjectMapper mapper = new ObjectMapper();
            KeystonesDataDTO data = mapper.readerFor(KeystonesDataDTO.class).readValue(response.body());
            for (KeystoneDataWrapper wrapper: data.getAllKeystoneData()) {
                Keystone k = new Keystone(
                        sequenceGeneratorService.generateSequence(Keystone.SEQUENCE_NAME),
                        wrapper.getKeystoneDataDTO().getName());
                keystoneService.save(k);
            }
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/modsToDb")
    public ResponseEntity<?> addModsToDb() {
        try {
//            String json = new String(Files.readAllBytes(Paths.get("src/main/resources/mods.json")));
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonNode = objectMapper.readTree(new File("C:\\Users\\Bodzan\\Desktop\\sbnz-23\\PoE-helper-backend\\src\\main\\resources\\mods.json"));

            Mods m = new Mods(2L, objectMapper.convertValue(jsonNode.get("quiver"), ModList.class),
                    objectMapper.convertValue(jsonNode.get("amulet"), ModList.class),objectMapper.convertValue(jsonNode.get("ring"), ModList.class),
                    objectMapper.convertValue(jsonNode.get("belt"), ModList.class),objectMapper.convertValue(jsonNode.get("shield"), ModList.class),
                    objectMapper.convertValue(jsonNode.get("helmet"), ModList.class),objectMapper.convertValue(jsonNode.get("boots"), ModList.class),
                    objectMapper.convertValue(jsonNode.get("gloves"), ModList.class),objectMapper.convertValue(jsonNode.get("body"), ModList.class));
            modsService.saveMods(m);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping(value = "/activeGems")
    public ResponseEntity<List<GemDTO>> getAllActiveSkillGems() {
        List<SkillGem> gems = skillGemService.getAllActiveGems();
        List<GemDTO> dtos = gems.stream().map(mapper::gemToDTO).collect(Collectors.toList());
        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }

    @GetMapping(value = "/supportGems")
    public ResponseEntity<List<GemDTO>> getAllSupportSkillGems() {
        List<SkillGem> gems = skillGemService.getAllSupportGems();
        List<GemDTO> dtos = gems.stream().map(mapper::gemToDTO).collect(Collectors.toList());
        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }

    @GetMapping(value = "/keystones")
    public ResponseEntity<List<KeystoneDataDTO>> getAllKeystones() {
        List<Keystone> keystones = keystoneService.getAll();
        List<KeystoneDataDTO> dtos = keystones.stream().map(mapper::keystoneToDTO).collect(Collectors.toList());
        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }


}
