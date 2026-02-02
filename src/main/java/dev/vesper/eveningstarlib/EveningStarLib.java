package dev.vesper.eveningstarlib;

import dev.vesper.eveningstarlib.common.Aurora.AuroraDefaultUniforms;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EveningStarLib {

    public static final String MOD_ID = "eveningstarlib";
    public static final Logger LOG = LoggerFactory.getLogger(MOD_ID);

    public static void init() {
        LOG.info("Initializing {} on {}", MOD_ID, Platform.INSTANCE.loader());
    }

}
