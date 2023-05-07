package ftn.sbzn.PoEhelperbackend.controller;

import ftn.sbzn.PoEhelperbackend.dto.FirstEntryDTO;
import ftn.sbzn.PoEhelperbackend.dto.KeystonesDataDTO;
import ftn.sbzn.PoEhelperbackend.dto.SecondEntryDTO;
import ftn.sbzn.PoEhelperbackend.model.Build;
import ftn.sbzn.PoEhelperbackend.model.ItemRecommendations;
import ftn.sbzn.PoEhelperbackend.model.SkillGem;
import ftn.sbzn.PoEhelperbackend.model.Tag;
import ftn.sbzn.PoEhelperbackend.service.BuildService;
import ftn.sbzn.PoEhelperbackend.service.KeystoneService;
import ftn.sbzn.PoEhelperbackend.service.SequenceGeneratorService;
import ftn.sbzn.PoEhelperbackend.service.SkillGemService;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.AgendaFilter;
import org.kie.api.runtime.rule.Match;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping(value = "/api/input")
public class UserInputController {

    @Autowired
    SkillGemService skillGemService;

    @Autowired
    private KieContainer kieContainer;

    @Autowired
    SequenceGeneratorService sequenceGeneratorService;

    @Autowired
    BuildService buildService;

    @Autowired
    KeystoneService keystoneService;


    @PostMapping(value = "/firstEntry")
    public ResponseEntity<?> firstEntry(@RequestBody FirstEntryDTO firstEntryDTO) {
        KieSession kieSession = kieContainer.newKieSession("ksession-rules");
        try {
            Build newBuild = new Build();
            newBuild.setId(sequenceGeneratorService.generateSequence(Build.SEQUENCE_NAME));
            for (String gem : firstEntryDTO.getSkillSetup()) {
                Optional<SkillGem> skillGem = skillGemService.getByName(gem);
                SkillGem sg = skillGem.orElseThrow();
                if (sg.getClassId().equals("Active Skill Gem")) {
                    newBuild.getMainSkills().add(sg.getName());
                }

                for (String tag : sg.getGemTags()) {
                    Tag t = new Tag(tag);

                    System.out.println(t);
                    kieSession.insert(t);

                }

            }
            kieSession.insert(newBuild);

            kieSession.getAgenda().getAgendaGroup("collect").setFocus();
            kieSession.fireAllRules();

            System.out.println(kieSession.getFactCount());

            newBuild = buildService.save(newBuild);

            return new ResponseEntity<>(newBuild, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

    }


    @PostMapping(value = "/secondEntry")
    public ResponseEntity<ItemRecommendations> secondEntry(@RequestBody SecondEntryDTO secondEntry) {
        KieSession kieSession = kieContainer.newKieSession("ksession-rules");
        ItemRecommendations itemRecommendations = new ItemRecommendations();
        for (String item: secondEntry.getSelectedEquipment()) {
            if (item.equals("helmet")) {
                itemRecommendations.setHelmetSelected(true);
            }
            if (item.equals("boots")) {
                itemRecommendations.setBootsSelected(true);
            }
            if (item.equals("gloves")) {
                itemRecommendations.setGlovesSelected(true);
            }
            if (item.equals("belt")) {
                itemRecommendations.setBeltSelected(true);
            }
            if (item.equals("amulet")) {
                itemRecommendations.setAmuletSelected(true);
            }
            if (item.equals("body armour")) {
                itemRecommendations.setBodyArmourSelected(true);
            }
            if (item.equals("ring1")) {
                itemRecommendations.setRing1Selected(true);
            }
            if (item.equals("ring2")) {
                itemRecommendations.setRing2Selected(true);
            }
            if (item.equals("offhand")) {
                itemRecommendations.setOffHandSelected(true);
            }
            if (item.equals("mainhand")) {
                itemRecommendations.setMainHandSelected(true);
            }
        }

        Optional<Build> build = buildService.getById(secondEntry.getBuildId());
        if (build.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        kieSession.insert(itemRecommendations);
        Build b = build.get();
        kieSession.insert(b);
        kieSession.fireAllRules();
        return new ResponseEntity<>(itemRecommendations, HttpStatus.OK);
    }

}
