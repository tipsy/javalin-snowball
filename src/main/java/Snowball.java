import io.javalin.Javalin;
import io.javalin.http.BadRequestResponse;
import io.javalin.http.RequestLogger;
import io.javalin.plugin.rendering.vue.JavalinVue;
import io.javalin.plugin.rendering.vue.VueComponent;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Snowball {

    private static Logger log = LoggerFactory.getLogger(Snowball.class);
    private static RequestLogger requestLogger = (ctx, time) -> {
        log.info(LocalDateTime.now() + ": " + ctx.method() + " " + ctx.url() + " (" + ctx.status() + ")");
    };

    public static void main(String[] args) {

        Javalin app = Javalin.create(config -> {
            config.enableWebjars();
            config.requestLogger(requestLogger);
        }).start(7000);

        app.get("/", ctx -> ctx.redirect("/enter-msisdn"));
        app.get("/enter-msisdn", new VueComponent("<enter-msisdn></enter-msisdn>"));
        app.get("/enter-pin", new VueComponent("<enter-pin></enter-pin>"));
        app.get("/enter-email", new VueComponent("<enter-email></enter-email>"));

        app.post("/verify-msisdn", ctx -> {
            String msisdn = ctx.body();
            if (msisdn.length() < 8) {
                throw new BadRequestResponse("MSISDN_TOO_SHORT");
            }
            if (!msisdn.startsWith("999")) {
                throw new BadRequestResponse("MSISDN_INVALID");
            }
            ctx.sessionAttribute("currentMsisdn", msisdn);
            ctx.result("enter-pin");
        });

        app.post("/verify-pin", ctx -> {
            String msisdn = ctx.body();
            if (msisdn.length() < 4) {
                throw new BadRequestResponse("PIN_INVALID");
            }
            ctx.sessionAttribute("verifiedMsisdn", ctx.sessionAttribute("currentMsisdn"));
            ctx.result("enter-email");
        });

        JavalinVue.INSTANCE.setStateFunction(ctx -> {
            Map<String, Object> state = new HashMap<>();
            state.put("currentMsisdn", ctx.sessionAttribute("currentMsisdn"));
            state.put("verifiedMsisdn", ctx.sessionAttribute("verifiedMsisdn"));
            return state;
        });

    }

}
