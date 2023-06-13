package ftn.sbzn.PoEhelperbackend.controller;

import ftn.sbzn.PoEhelperbackend.model.Build;
import ftn.sbzn.PoEhelperbackend.model.ItemRecommendations;
import ftn.sbzn.PoEhelperbackend.model.Mods;
import ftn.sbzn.PoEhelperbackend.model.Tag;
import ftn.sbzn.PoEhelperbackend.service.ModsService;
import org.kie.api.KieServices;
import org.kie.api.builder.KieScanner;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/test")
public class TestController {


    @Autowired
    private ModsService modsService;

    @GetMapping(value = "/t1")
    public ResponseEntity<Object> test() {
        KieServices ks = KieServices.Factory.get();
        KieContainer kContainer = ks.newKieContainer(ks.newReleaseId("sbnz.projekat", "poe-helper-kjar", "0.0.1-SNAPSHOT"));
        KieScanner kScanner = ks.newKieScanner(kContainer);
        kScanner.start(10_000);
        KieSession session = kContainer.newKieSession("ksession-rules");
//        AgendaFilter filter = match -> {
//            return match.getRule().getName().equals("Collect all tags");
//        };
        Tag t1 = new Tag();
        t1.setName("Fire");
        Build b = new Build();
//        Set<String> tags = new HashSet<>();
//        b.setTags(tags);
//        tags.add()
        Mods mods = modsService.getAllMods();
        ItemRecommendations ir = new ItemRecommendations();
        ir.setHelmetSelected(true);

        session.insert(t1);
        session.insert(b);
        session.insert(mods);
        session.insert(ir);
//        session.getAgenda().getAgendaGroup("build").setFocus();
        long count = session.fireAllRules();

        return new ResponseEntity<>(count, HttpStatus.OK);
    }
}
