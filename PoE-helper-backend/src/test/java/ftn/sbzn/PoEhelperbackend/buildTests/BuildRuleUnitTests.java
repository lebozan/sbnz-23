package ftn.sbzn.PoEhelperbackend.buildTests;

import ftn.sbzn.PoEhelperbackend.model.Build;
import ftn.sbzn.PoEhelperbackend.model.Tag;
import org.junit.Test;
import org.kie.api.KieServices;
import org.kie.api.builder.KieScanner;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.AgendaFilter;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class BuildRuleUnitTests {

    @Test
    public void collectAllTags() {
        KieServices ks = KieServices.Factory.get();
        KieContainer kContainer = ks
                .newKieContainer(ks.newReleaseId("sbnz.projekat", "poe-helper-kjar", "0.0.1-SNAPSHOT"));
        KieScanner kScanner = ks.newKieScanner(kContainer);
        kScanner.start(10_000);
        KieSession session = kContainer.newKieSession("ksession-rules");
        AgendaFilter filter = match -> {
            return match.getRule().getName().equals("Collect all tags");
        };
        Tag t1 = new Tag();
        t1.setName("Cold");
        Build b = new Build();
//        Set<String> tags = new HashSet<>();
//        b.setTags(tags);
//        tags.add()

        session.insert(t1);
        session.insert(b);
        session.getAgenda().getAgendaGroup("build").setFocus();
        long count = session.fireAllRules(filter);

//        assertNotNull(b.getTags());
        assertEquals(1L, count);
    }
}
