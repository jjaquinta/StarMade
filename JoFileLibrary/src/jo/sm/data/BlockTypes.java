package jo.sm.data;

import java.util.HashMap;
import java.util.Map;

public class BlockTypes
{
    public static final short WEAPON_CONTROLLER_ID=6;
    public static final short WEAPON_ID=16;
    public static final short CORE_ID=1;
    public static final short DEATHSTAR_CORE_ID=65;
    public static final short GLASS_ID=63;
    public static final short THRUSTER_ID=8;
    public static final short DOCK_ID=7;
    public static final short POWER_ID=2;
    public static final short SHIELD_ID=3;
    public static final short EXPLOSIVE_ID=14;
    public static final short RADAR_JAMMING_ID=15;
    public static final short CLOAKING_ID=22;
    public static final short SALVAGE_ID=24;
    public static final short MISSILE_DUMB_CONTROLLER_ID=38;
    public static final short MISSILE_DUMB_ID=32;
    public static final short MISSILE_HEAT_CONTROLLER_ID=46;
    public static final short MISSILE_HEAT_ID=40;
    public static final short MISSILE_FAFO_CONTROLLER_ID=54;
    public static final short MISSILE_FAFO_ID=48;
    public static final short SALVAGE_CONTROLLER_ID=4;
    public static final short GRAVITY_ID=56;
    public static final short REPAIR_ID=30;
    public static final short REPAIR_CONTROLLER_ID=39;
    public static final short COCKPIT_ID=47;
    public static final short LIGHT_ID=55;
    public static final short LIGHT_BEACON_ID=62;
    public static final short TERRAIN_ICE_ID=64;
    public static final short HULL_COLOR_GREY_ID=5;
    public static final short HULL_COLOR_PURPLE_ID=69;
    public static final short HULL_COLOR_BROWN_ID=70;
    public static final short HULL_COLOR_BLACK_ID=75;
    public static final short HULL_COLOR_RED_ID=76;
    public static final short HULL_COLOR_BLUE_ID=77;
    public static final short HULL_COLOR_GREEN_ID=78;
    public static final short HULL_COLOR_YELLOW_ID=79;
    public static final short HULL_COLOR_WHITE_ID=81;
    public static final short LANDING_ELEMENT=112;
    public static final short LIFT_ELEMENT=113;
    public static final short RECYCLER_ELEMENT=114;
    public static final short STASH_ELEMENT=120;
    public static final short AI_ELEMENT=121;
    public static final short DOOR_ELEMENT=122;
    public static final short BUILD_BLOCK_ID=123;
    public static final short TERRAIN_LAVA_ID=80;
    public static final short TERRAIN_EXOGEN_ID=128;
    public static final short TERRAIN_OCTOGEN_ID=129;
    public static final short TERRAIN_QUANTAGEN_ID=130;
    public static final short TERRAIN_QUANTANIUM_ID=131;
    public static final short TERRAIN_PLEXTANIUM_ID=132;
    public static final short TERRAIN_ORANGUTANIUM_ID=133;
    public static final short TERRAIN_SUCCUMITE_ID=134;
    public static final short TERRAIN_CENOMITE_ID=135;
    public static final short TERRAIN_AWESOMITE_ID=136;
    public static final short TERRAIN_VAPPECIDE_ID=137;
    public static final short TERRAIN_MARS_TOP=138;
    public static final short TERRAIN_MARS_ROCK=139;
    public static final short TERRAIN_MARS_DIRT=140;
    public static final short TERRAIN_MARS_TOP_ROCK=141;
    public static final short TERRAIN_EXTRANIUM_ID=72;
    public static final short TERRAIN_ROCK_ID=73;
    public static final short TERRAIN_SAND_ID=74;
    public static final short TERRAIN_EARTH_TOP_DIRT=82;
    public static final short TERRAIN_EARTH_TOP_ROCK=83;
    public static final short TERRAIN_TREE_TRUNK_ID=84;
    public static final short TERRAIN_TREE_LEAF_ID=85;
    public static final short TERRAIN_WATER=86;
    public static final short TERRAIN_DIRT_ID=87;
    public static final short DOCKING_ENHANCER_ID=88;
    public static final short TERRAIN_CACTUS_ID=89;
    public static final short TERRAIN_PURPLE_ALIEN_TOP=90;
    public static final short TERRAIN_PURPLE_ALIEN_ROCK=91;
    public static final short TERRAIN_PURPLE_ALIEN_VINE=92;
    public static final short TERRAIN_GRASS_SPRITE=93;
    public static final short PLAYER_SPAWN_MODULE=94;
    public static final short TERRAIN_BROWNWEED_SPRITE=95;
    public static final short TERRAIN_MARSTENTACLES_SPRITE=96;
    public static final short TERRAIN_ALIENVINE_SPRITE=97;
    public static final short TERRAIN_GRASSFLOWERS_SPRITE=98;
    public static final short TERRAIN_LONGWEED_SPRITE=99;
    public static final short TERRAIN_TALLSHROOM_SPRITE=100;
    public static final short TERRAIN_PURSPIRE_SPRITE=101;
    public static final short TERRAIN_TALLGRASSFLOWERS_SPRITE=102;
    public static final short TERRAIN_MINICACTUS_SPRITE=103;
    public static final short TERRAIN_REDSHROOM_SPRITE=104;
    public static final short TERRAIN_PURPTACLES_SPRITE=105;
    public static final short TERRAIN_TALLFLOWERS_SPRITE=106;
    public static final short TERRAIN_ROCK_SPRITE=107;
    public static final short TERRAIN_ALIENFLOWERS_SPRITE=108;
    public static final short TERRAIN_YHOLE_SPRITE=109;
    public static final short TERRAIN_M1L2_ID=142;
    public static final short TERRAIN_M1L3_ID=143;
    public static final short TERRAIN_M1L4_ID=144;
    public static final short TERRAIN_M1L5_ID=145;
    public static final short TERRAIN_M2L2_ID=146;
    public static final short TERRAIN_M2L3_ID=147;
    public static final short TERRAIN_M2L4_ID=148;
    public static final short TERRAIN_M2L5_ID=149;
    public static final short TERRAIN_M3L2_ID=150;
    public static final short TERRAIN_M3L3_ID=151;
    public static final short TERRAIN_M3L4_ID=152;
    public static final short TERRAIN_M3L5_ID=153;
    public static final short TERRAIN_M4L2_ID=154;
    public static final short TERRAIN_M4L3_ID=155;
    public static final short TERRAIN_M4L4_ID=156;
    public static final short TERRAIN_M4L5_ID=157;
    public static final short TERRAIN_M5L2_ID=158;
    public static final short TERRAIN_M5L3_ID=159;
    public static final short TERRAIN_M5L4_ID=160;
    public static final short TERRAIN_M5L5_ID=161;
    public static final short TERRAIN_M6L2_ID=162;
    public static final short TERRAIN_M6L3_ID=163;
    public static final short TERRAIN_M6L4_ID=164;
    public static final short TERRAIN_M6L5_ID=165;
    public static final short TERRAIN_M7L2_ID=166;
    public static final short TERRAIN_M7L3_ID=167;
    public static final short TERRAIN_M7L4_ID=168;
    public static final short TERRAIN_M7L5_ID=169;
    public static final short TERRAIN_M8L2_ID=170;
    public static final short TERRAIN_M8L3_ID=171;
    public static final short TERRAIN_M8L4_ID=172;
    public static final short TERRAIN_M8L5_ID=173;
    public static final short TERRAIN_M9L2_ID=174;
    public static final short TERRAIN_M9L3_ID=175;
    public static final short TERRAIN_M9L4_ID=176;
    public static final short TERRAIN_M9L5_ID=177;
    public static final short TERRAIN_M10L2_ID=178;
    public static final short TERRAIN_M10L3_ID=179;
    public static final short TERRAIN_M10L4_ID=180;
    public static final short TERRAIN_M10L5_ID=181;
    public static final short TERRAIN_M11L2_ID=182;
    public static final short TERRAIN_M11L3_ID=183;
    public static final short TERRAIN_M11L4_ID=184;
    public static final short TERRAIN_M11L5_ID=185;
    public static final short TERRAIN_M12L2_ID=186;
    public static final short TERRAIN_M12L3_ID=187;
    public static final short TERRAIN_M12L4_ID=188;
    public static final short TERRAIN_M12L5_ID=189;
    public static final short TERRAIN_M13L2_ID=190;
    public static final short TERRAIN_M13L3_ID=191;
    public static final short TERRAIN_M13L4_ID=192;
    public static final short TERRAIN_M13L5_ID=193;
    public static final short TERRAIN_M14L2_ID=194;
    public static final short TERRAIN_M14L3_ID=195;
    public static final short TERRAIN_M14L4_ID=196;
    public static final short TERRAIN_M14L5_ID=197;
    public static final short TERRAIN_M15L2_ID=198;
    public static final short TERRAIN_M15L3_ID=199;
    public static final short TERRAIN_M15L4_ID=200;
    public static final short TERRAIN_M15L5_ID=201;
    public static final short TERRAIN_M16L2_ID=202;
    public static final short TERRAIN_M16L3_ID=203;
    public static final short TERRAIN_M16L4_ID=204;
    public static final short TERRAIN_M16L5_ID=205;
    public static final short TERRAIN_NEGACIDE_ID=206;
    public static final short TERRAIN_QUANTACIDE_ID=207;
    public static final short TERRAIN_NEGAGATE_ID=208;
    public static final short TERRAIN_METATE_ID=209;
    public static final short TERRAIN_INSANIUM_ID=210;
    public static final short FACTORY_INPUT_ID=211;
    public static final short FACTORY_INPUT_ENH_ID=212;
    public static final short FACTORY_POWER_CELL_ID=213;
    public static final short FACTORY_POWER_CELL_ENH_ID=214;
    public static final short FACTORY_POWER_COIL_ID=215;
    public static final short FACTORY_POWER_COIL_ENH_ID=216;
    public static final short FACTORY_POWER_BLOCK_ID=217;
    public static final short FACTORY_POWER_BLOCK_ENH_ID=218;
    public static final short POWER_CELL_ID=219;
    public static final short POWER_COIL_ID=220;
    public static final short UNUSED_TEST=221;
    public static final short FACTORY_PARTICLE_PRESS=222;
    public static final short MAN_SD1000_CAP=223;
    public static final short MAN_SD2000_CAP=224;
    public static final short MAN_SD3000_CAP=225;
    public static final short MAN_SD1000_FLUX=226;
    public static final short MAN_SD2000_FLUX=227;
    public static final short MAN_SD3000_FLUX=228;
    public static final short MAN_SD1000_MICRO=229;
    public static final short MAN_SD2000_MICRO=230;
    public static final short MAN_SD3000_MICRO=231;
    public static final short MAN_SD1000_DELTA=232;
    public static final short MAN_SD2000_DELTA=233;
    public static final short MAN_SD3000_DELTA=234;
    public static final short MAN_SD1000_MEM=235;
    public static final short MAN_SD2000_MEM=236;
    public static final short MAN_SD3000_MEM=237;
    public static final short MAN_SDPROTON=238;
    public static final short MAN_RED=239;
    public static final short MAN_PURP=240;
    public static final short MAN_BROWN=241;
    public static final short MAN_GREEN=242;
    public static final short MAN_YELLOW=243;
    public static final short MAN_BLACK=244;
    public static final short MAN_WHITE=245;
    public static final short MAN_BLUE=246;
    public static final short MAN_P1000B=247;
    public static final short MAN_P2000B=248;
    public static final short MAN_P3000B=249;
    public static final short MAN_P10000A=250;
    public static final short MAN_P20000A=251;
    public static final short MAN_P30000A=252;
    public static final short MAN_P40000A=253;
    public static final short MAN_YHOLE_NUC=254;
    public static final short FACTORY_SD10000=255;
    public static final short FACTORY_SD20000=256;
    public static final short FACTORY_SD30000=257;
    public static final short FACTORY_SDADV=258;
    public static final short FACTORY_SD1000=259;
    public static final short FACTORY_SD2000=260;
    public static final short FACTORY_SD3000=261;
    public static final short FACTORY_MINERAL=262;
    public static final short POWERHULL_COLOR_GREY=263;
    public static final short POWERHULL_COLOR_BLACK=264;
    public static final short POWERHULL_COLOR_RED=265;
    public static final short POWERHULL_COLOR_PURPLE=266;
    public static final short POWERHULL_COLOR_BLUE=267;
    public static final short POWERHULL_COLOR_GREEN=268;
    public static final short POWERHULL_COLOR_BROWN=269;
    public static final short POWERHULL_COLOR_GOLD=270;
    public static final short POWERHULL_COLOR_WHITE=271;
    public static final short MAN_GLASS_BOTTLE=272;
    public static final short MAN_SCIENCE_BOTTLE=273;
    public static final short TERRAIN_ICEPLANET_SURFACE=274;
    public static final short TERRAIN_ICEPLANET_ROCK=275;
    public static final short TERRAIN_ICEPLANET_WOOD=276;
    public static final short TERRAIN_ICEPLANET_LEAVES=277;
    public static final short TERRAIN_ICEPLANET_SPIKE_SPRITE=278;
    public static final short TERRAIN_ICEPLANET_ICECRAG_SPRITE=279;
    public static final short TERRAIN_ICEPLANET_ICECORAL_SPRITE=280;
    public static final short TERRAIN_ICEPLANET_ICEGRASS_SPRITE=281;
    public static final short LIGHT_RED=282;
    public static final short LIGHT_BLUE=283;
    public static final short LIGHT_GREEN=284;
    public static final short LIGHT_YELLOW=285;
    public static final short TERRAIN_ICEPLANET_CRYSTAL=286;
    public static final short TERRAIN_REDWOOD=287;
    public static final short TERRAIN_REDWOOD_LEAVES=288;
    public static final short FIXED_DOCK_ID=289;
    public static final short FIXED_DOCK_ID_ENHANCER=290;
    public static final short FACTION_BLOCK=291;
    public static final short FACTION_HUB_BLOCK=292;
    public static final short HULL_COLOR_WEDGE_GREY_ID=293;
    public static final short HULL_COLOR_WEDGE_PURPLE_ID=294;
    public static final short HULL_COLOR_WEDGE_BROWN_ID=295;
    public static final short HULL_COLOR_WEDGE_BLACK_ID=296;
    public static final short HULL_COLOR_WEDGE_RED_ID=297;
    public static final short HULL_COLOR_WEDGE_BLUE_ID=298;
    public static final short HULL_COLOR_WEDGE_GREEN_ID=299;
    public static final short HULL_COLOR_WEDGE_YELLOW_ID=300;
    public static final short HULL_COLOR_WEDGE_WHITE_ID=301;
    public static final short HULL_COLOR_CORNER_GREY_ID=302;
    public static final short HULL_COLOR_CORNER_PURPLE_ID=303;
    public static final short HULL_COLOR_CORNER_BROWN_ID=304;
    public static final short HULL_COLOR_CORNER_BLACK_ID=305;
    public static final short HULL_COLOR_CORNER_RED_ID=306;
    public static final short HULL_COLOR_CORNER_BLUE_ID=307;
    public static final short HULL_COLOR_CORNER_GREEN_ID=308;
    public static final short HULL_COLOR_CORNER_YELLOW_ID=309;
    public static final short HULL_COLOR_CORNER_WHITE_ID=310;
    public static final short POWERHULL_COLOR_WEDGE_GREY=311;
    public static final short POWERHULL_COLOR_WEDGE_BLACK=312;
    public static final short POWERHULL_COLOR_WEDGE_RED=313;
    public static final short POWERHULL_COLOR_WEDGE_PURPLE=314;
    public static final short POWERHULL_COLOR_WEDGE_BLUE=315;
    public static final short POWERHULL_COLOR_WEDGE_GREEN=316;
    public static final short POWERHULL_COLOR_WEDGE_BROWN=317;
    public static final short POWERHULL_COLOR_WEDGE_GOLD=318;
    public static final short POWERHULL_COLOR_WEDGE_WHITE=319;
    public static final short POWERHULL_COLOR_CORNER_GREY=320;
    public static final short POWERHULL_COLOR_CORNER_BLACK=321;
    public static final short POWERHULL_COLOR_CORNER_RED=322;
    public static final short POWERHULL_COLOR_CORNER_PURPLE=323;
    public static final short POWERHULL_COLOR_CORNER_BLUE=324;
    public static final short POWERHULL_COLOR_CORNER_GREEN=325;
    public static final short POWERHULL_COLOR_CORNER_BROWN=326;
    public static final short POWERHULL_COLOR_CORNER_GOLD=327;
    public static final short POWERHULL_COLOR_CORNER_WHITE=328;
    public static final short GLASS_WEDGE_ID=329;
    public static final short GLASS_CORNER_ID=330;
    public static final short POWER_HOLDER_ID=331;
    public static final short POWER_DRAIN_BEAM_COMPUTER=332;
    public static final short POWER_DRAIN_BEAM_MODULE=333;
    public static final short POWER_SUPPLY_BEAM_COMPUTER=334;
    public static final short POWER_SUPPLY_BEAM_MODULE=335;
    public static final short DECORATIVE_PANEL_1=336;
    public static final short DECORATIVE_PANEL_2=337;
    public static final short DECORATIVE_PANEL_3=338;
    public static final short DECORATIVE_PANEL_4=339;
    public static final short LIGHT_BULB_YELLOW=340;

    public static final Map<Short,String> BLOCK_NAMES = new HashMap<Short, String>();
    static
    {
        BLOCK_NAMES.put((short)0, "Empty");
        BLOCK_NAMES.put(WEAPON_CONTROLLER_ID, "WEAPON_CONTROLLER");
        BLOCK_NAMES.put(WEAPON_ID, "WEAPON");
        BLOCK_NAMES.put(CORE_ID, "CORE");
        BLOCK_NAMES.put(DEATHSTAR_CORE_ID, "DEATHSTAR_CORE");
        BLOCK_NAMES.put(GLASS_ID, "GLASS");
        BLOCK_NAMES.put(THRUSTER_ID, "THRUSTER");
        BLOCK_NAMES.put(DOCK_ID, "DOCK");
        BLOCK_NAMES.put(POWER_ID, "POWER");
        BLOCK_NAMES.put(SHIELD_ID, "SHIELD");
        BLOCK_NAMES.put(EXPLOSIVE_ID, "EXPLOSIVE");
        BLOCK_NAMES.put(RADAR_JAMMING_ID, "RADAR_JAMMING");
        BLOCK_NAMES.put(CLOAKING_ID, "CLOAKING");
        BLOCK_NAMES.put(SALVAGE_ID, "SALVAGE");
        BLOCK_NAMES.put(MISSILE_DUMB_CONTROLLER_ID, "MISSILE_DUMB_CONTROLLER");
        BLOCK_NAMES.put(MISSILE_DUMB_ID, "MISSILE_DUMB");
        BLOCK_NAMES.put(MISSILE_HEAT_CONTROLLER_ID, "MISSILE_HEAT_CONTROLLER");
        BLOCK_NAMES.put(MISSILE_HEAT_ID, "MISSILE_HEAT");
        BLOCK_NAMES.put(MISSILE_FAFO_CONTROLLER_ID, "MISSILE_FAFO_CONTROLLER");
        BLOCK_NAMES.put(MISSILE_FAFO_ID, "MISSILE_FAFO");
        BLOCK_NAMES.put(SALVAGE_CONTROLLER_ID, "SALVAGE_CONTROLLER");
        BLOCK_NAMES.put(GRAVITY_ID, "GRAVITY");
        BLOCK_NAMES.put(REPAIR_ID, "REPAIR");
        BLOCK_NAMES.put(REPAIR_CONTROLLER_ID, "REPAIR_CONTROLLER");
        BLOCK_NAMES.put(COCKPIT_ID, "COCKPIT");
        BLOCK_NAMES.put(LIGHT_ID, "LIGHT");
        BLOCK_NAMES.put(LIGHT_BEACON_ID, "LIGHT_BEACON");
        BLOCK_NAMES.put(TERRAIN_ICE_ID, "TERRAIN_ICE");
        BLOCK_NAMES.put(HULL_COLOR_GREY_ID, "HULL_COLOR_GREY");
        BLOCK_NAMES.put(HULL_COLOR_PURPLE_ID, "HULL_COLOR_PURPLE");
        BLOCK_NAMES.put(HULL_COLOR_BROWN_ID, "HULL_COLOR_BROWN");
        BLOCK_NAMES.put(HULL_COLOR_BLACK_ID, "HULL_COLOR_BLACK");
        BLOCK_NAMES.put(HULL_COLOR_RED_ID, "HULL_COLOR_RED");
        BLOCK_NAMES.put(HULL_COLOR_BLUE_ID, "HULL_COLOR_BLUE");
        BLOCK_NAMES.put(HULL_COLOR_GREEN_ID, "HULL_COLOR_GREEN");
        BLOCK_NAMES.put(HULL_COLOR_YELLOW_ID, "HULL_COLOR_YELLOW");
        BLOCK_NAMES.put(HULL_COLOR_WHITE_ID, "HULL_COLOR_WHITE");
        BLOCK_NAMES.put(LANDING_ELEMENT, "LANDING_ELEMENT");
        BLOCK_NAMES.put(LIFT_ELEMENT, "LIFT_ELEMENT");
        BLOCK_NAMES.put(RECYCLER_ELEMENT, "RECYCLER_ELEMENT");
        BLOCK_NAMES.put(STASH_ELEMENT, "STASH_ELEMENT");
        BLOCK_NAMES.put(AI_ELEMENT, "AI_ELEMENT");
        BLOCK_NAMES.put(DOOR_ELEMENT, "DOOR_ELEMENT");
        BLOCK_NAMES.put(BUILD_BLOCK_ID, "BUILD_BLOCK");
        BLOCK_NAMES.put(TERRAIN_LAVA_ID, "TERRAIN_LAVA");
        BLOCK_NAMES.put(TERRAIN_EXOGEN_ID, "TERRAIN_EXOGEN");
        BLOCK_NAMES.put(TERRAIN_OCTOGEN_ID, "TERRAIN_OCTOGEN");
        BLOCK_NAMES.put(TERRAIN_QUANTAGEN_ID, "TERRAIN_QUANTAGEN");
        BLOCK_NAMES.put(TERRAIN_QUANTANIUM_ID, "TERRAIN_QUANTANIUM");
        BLOCK_NAMES.put(TERRAIN_PLEXTANIUM_ID, "TERRAIN_PLEXTANIUM");
        BLOCK_NAMES.put(TERRAIN_ORANGUTANIUM_ID, "TERRAIN_ORANGUTANIUM");
        BLOCK_NAMES.put(TERRAIN_SUCCUMITE_ID, "TERRAIN_SUCCUMITE");
        BLOCK_NAMES.put(TERRAIN_CENOMITE_ID, "TERRAIN_CENOMITE");
        BLOCK_NAMES.put(TERRAIN_AWESOMITE_ID, "TERRAIN_AWESOMITE");
        BLOCK_NAMES.put(TERRAIN_VAPPECIDE_ID, "TERRAIN_VAPPECIDE");
        BLOCK_NAMES.put(TERRAIN_MARS_TOP, "TERRAIN_MARS_TOP");
        BLOCK_NAMES.put(TERRAIN_MARS_ROCK, "TERRAIN_MARS_ROCK");
        BLOCK_NAMES.put(TERRAIN_MARS_DIRT, "TERRAIN_MARS_DIRT");
        BLOCK_NAMES.put(TERRAIN_MARS_TOP_ROCK, "TERRAIN_MARS_TOP_ROCK");
        BLOCK_NAMES.put(TERRAIN_EXTRANIUM_ID, "TERRAIN_EXTRANIUM");
        BLOCK_NAMES.put(TERRAIN_ROCK_ID, "TERRAIN_ROCK");
        BLOCK_NAMES.put(TERRAIN_SAND_ID, "TERRAIN_SAND");
        BLOCK_NAMES.put(TERRAIN_EARTH_TOP_DIRT, "TERRAIN_EARTH_TOP_DIRT");
        BLOCK_NAMES.put(TERRAIN_EARTH_TOP_ROCK, "TERRAIN_EARTH_TOP_ROCK");
        BLOCK_NAMES.put(TERRAIN_TREE_TRUNK_ID, "TERRAIN_TREE_TRUNK");
        BLOCK_NAMES.put(TERRAIN_TREE_LEAF_ID, "TERRAIN_TREE_LEAF");
        BLOCK_NAMES.put(TERRAIN_WATER, "TERRAIN_WATER");
        BLOCK_NAMES.put(TERRAIN_DIRT_ID, "TERRAIN_DIRT");
        BLOCK_NAMES.put(DOCKING_ENHANCER_ID, "DOCKING_ENHANCER");
        BLOCK_NAMES.put(TERRAIN_CACTUS_ID, "TERRAIN_CACTUS");
        BLOCK_NAMES.put(TERRAIN_PURPLE_ALIEN_TOP, "TERRAIN_PURPLE_ALIEN_TOP");
        BLOCK_NAMES.put(TERRAIN_PURPLE_ALIEN_ROCK, "TERRAIN_PURPLE_ALIEN_ROCK");
        BLOCK_NAMES.put(TERRAIN_PURPLE_ALIEN_VINE, "TERRAIN_PURPLE_ALIEN_VINE");
        BLOCK_NAMES.put(TERRAIN_GRASS_SPRITE, "TERRAIN_GRASS_SPRITE");
        BLOCK_NAMES.put(PLAYER_SPAWN_MODULE, "PLAYER_SPAWN_MODULE");
        BLOCK_NAMES.put(TERRAIN_BROWNWEED_SPRITE, "TERRAIN_BROWNWEED_SPRITE");
        BLOCK_NAMES.put(TERRAIN_MARSTENTACLES_SPRITE, "TERRAIN_MARSTENTACLES_SPRITE");
        BLOCK_NAMES.put(TERRAIN_ALIENVINE_SPRITE, "TERRAIN_ALIENVINE_SPRITE");
        BLOCK_NAMES.put(TERRAIN_GRASSFLOWERS_SPRITE, "TERRAIN_GRASSFLOWERS_SPRITE");
        BLOCK_NAMES.put(TERRAIN_LONGWEED_SPRITE, "TERRAIN_LONGWEED_SPRITE");
        BLOCK_NAMES.put(TERRAIN_TALLSHROOM_SPRITE, "TERRAIN_TALLSHROOM_SPRITE");
        BLOCK_NAMES.put(TERRAIN_PURSPIRE_SPRITE, "TERRAIN_PURSPIRE_SPRITE");
        BLOCK_NAMES.put(TERRAIN_TALLGRASSFLOWERS_SPRITE, "TERRAIN_TALLGRASSFLOWERS_SPRITE");
        BLOCK_NAMES.put(TERRAIN_MINICACTUS_SPRITE, "TERRAIN_MINICACTUS_SPRITE");
        BLOCK_NAMES.put(TERRAIN_REDSHROOM_SPRITE, "TERRAIN_REDSHROOM_SPRITE");
        BLOCK_NAMES.put(TERRAIN_PURPTACLES_SPRITE, "TERRAIN_PURPTACLES_SPRITE");
        BLOCK_NAMES.put(TERRAIN_TALLFLOWERS_SPRITE, "TERRAIN_TALLFLOWERS_SPRITE");
        BLOCK_NAMES.put(TERRAIN_ROCK_SPRITE, "TERRAIN_ROCK_SPRITE");
        BLOCK_NAMES.put(TERRAIN_ALIENFLOWERS_SPRITE, "TERRAIN_ALIENFLOWERS_SPRITE");
        BLOCK_NAMES.put(TERRAIN_YHOLE_SPRITE, "TERRAIN_YHOLE_SPRITE");
        BLOCK_NAMES.put(TERRAIN_M1L2_ID, "TERRAIN_M1L2");
        BLOCK_NAMES.put(TERRAIN_M1L3_ID, "TERRAIN_M1L3");
        BLOCK_NAMES.put(TERRAIN_M1L4_ID, "TERRAIN_M1L4");
        BLOCK_NAMES.put(TERRAIN_M1L5_ID, "TERRAIN_M1L5");
        BLOCK_NAMES.put(TERRAIN_M2L2_ID, "TERRAIN_M2L2");
        BLOCK_NAMES.put(TERRAIN_M2L3_ID, "TERRAIN_M2L3");
        BLOCK_NAMES.put(TERRAIN_M2L4_ID, "TERRAIN_M2L4");
        BLOCK_NAMES.put(TERRAIN_M2L5_ID, "TERRAIN_M2L5");
        BLOCK_NAMES.put(TERRAIN_M3L2_ID, "TERRAIN_M3L2");
        BLOCK_NAMES.put(TERRAIN_M3L3_ID, "TERRAIN_M3L3");
        BLOCK_NAMES.put(TERRAIN_M3L4_ID, "TERRAIN_M3L4");
        BLOCK_NAMES.put(TERRAIN_M3L5_ID, "TERRAIN_M3L5");
        BLOCK_NAMES.put(TERRAIN_M4L2_ID, "TERRAIN_M4L2");
        BLOCK_NAMES.put(TERRAIN_M4L3_ID, "TERRAIN_M4L3");
        BLOCK_NAMES.put(TERRAIN_M4L4_ID, "TERRAIN_M4L4");
        BLOCK_NAMES.put(TERRAIN_M4L5_ID, "TERRAIN_M4L5");
        BLOCK_NAMES.put(TERRAIN_M5L2_ID, "TERRAIN_M5L2");
        BLOCK_NAMES.put(TERRAIN_M5L3_ID, "TERRAIN_M5L3");
        BLOCK_NAMES.put(TERRAIN_M5L4_ID, "TERRAIN_M5L4");
        BLOCK_NAMES.put(TERRAIN_M5L5_ID, "TERRAIN_M5L5");
        BLOCK_NAMES.put(TERRAIN_M6L2_ID, "TERRAIN_M6L2");
        BLOCK_NAMES.put(TERRAIN_M6L3_ID, "TERRAIN_M6L3");
        BLOCK_NAMES.put(TERRAIN_M6L4_ID, "TERRAIN_M6L4");
        BLOCK_NAMES.put(TERRAIN_M6L5_ID, "TERRAIN_M6L5");
        BLOCK_NAMES.put(TERRAIN_M7L2_ID, "TERRAIN_M7L2");
        BLOCK_NAMES.put(TERRAIN_M7L3_ID, "TERRAIN_M7L3");
        BLOCK_NAMES.put(TERRAIN_M7L4_ID, "TERRAIN_M7L4");
        BLOCK_NAMES.put(TERRAIN_M7L5_ID, "TERRAIN_M7L5");
        BLOCK_NAMES.put(TERRAIN_M8L2_ID, "TERRAIN_M8L2");
        BLOCK_NAMES.put(TERRAIN_M8L3_ID, "TERRAIN_M8L3");
        BLOCK_NAMES.put(TERRAIN_M8L4_ID, "TERRAIN_M8L4");
        BLOCK_NAMES.put(TERRAIN_M8L5_ID, "TERRAIN_M8L5");
        BLOCK_NAMES.put(TERRAIN_M9L2_ID, "TERRAIN_M9L2");
        BLOCK_NAMES.put(TERRAIN_M9L3_ID, "TERRAIN_M9L3");
        BLOCK_NAMES.put(TERRAIN_M9L4_ID, "TERRAIN_M9L4");
        BLOCK_NAMES.put(TERRAIN_M9L5_ID, "TERRAIN_M9L5");
        BLOCK_NAMES.put(TERRAIN_M10L2_ID, "TERRAIN_M10L2");
        BLOCK_NAMES.put(TERRAIN_M10L3_ID, "TERRAIN_M10L3");
        BLOCK_NAMES.put(TERRAIN_M10L4_ID, "TERRAIN_M10L4");
        BLOCK_NAMES.put(TERRAIN_M10L5_ID, "TERRAIN_M10L5");
        BLOCK_NAMES.put(TERRAIN_M11L2_ID, "TERRAIN_M11L2");
        BLOCK_NAMES.put(TERRAIN_M11L3_ID, "TERRAIN_M11L3");
        BLOCK_NAMES.put(TERRAIN_M11L4_ID, "TERRAIN_M11L4");
        BLOCK_NAMES.put(TERRAIN_M11L5_ID, "TERRAIN_M11L5");
        BLOCK_NAMES.put(TERRAIN_M12L2_ID, "TERRAIN_M12L2");
        BLOCK_NAMES.put(TERRAIN_M12L3_ID, "TERRAIN_M12L3");
        BLOCK_NAMES.put(TERRAIN_M12L4_ID, "TERRAIN_M12L4");
        BLOCK_NAMES.put(TERRAIN_M12L5_ID, "TERRAIN_M12L5");
        BLOCK_NAMES.put(TERRAIN_M13L2_ID, "TERRAIN_M13L2");
        BLOCK_NAMES.put(TERRAIN_M13L3_ID, "TERRAIN_M13L3");
        BLOCK_NAMES.put(TERRAIN_M13L4_ID, "TERRAIN_M13L4");
        BLOCK_NAMES.put(TERRAIN_M13L5_ID, "TERRAIN_M13L5");
        BLOCK_NAMES.put(TERRAIN_M14L2_ID, "TERRAIN_M14L2");
        BLOCK_NAMES.put(TERRAIN_M14L3_ID, "TERRAIN_M14L3");
        BLOCK_NAMES.put(TERRAIN_M14L4_ID, "TERRAIN_M14L4");
        BLOCK_NAMES.put(TERRAIN_M14L5_ID, "TERRAIN_M14L5");
        BLOCK_NAMES.put(TERRAIN_M15L2_ID, "TERRAIN_M15L2");
        BLOCK_NAMES.put(TERRAIN_M15L3_ID, "TERRAIN_M15L3");
        BLOCK_NAMES.put(TERRAIN_M15L4_ID, "TERRAIN_M15L4");
        BLOCK_NAMES.put(TERRAIN_M15L5_ID, "TERRAIN_M15L5");
        BLOCK_NAMES.put(TERRAIN_M16L2_ID, "TERRAIN_M16L2");
        BLOCK_NAMES.put(TERRAIN_M16L3_ID, "TERRAIN_M16L3");
        BLOCK_NAMES.put(TERRAIN_M16L4_ID, "TERRAIN_M16L4");
        BLOCK_NAMES.put(TERRAIN_M16L5_ID, "TERRAIN_M16L5");
        BLOCK_NAMES.put(TERRAIN_NEGACIDE_ID, "TERRAIN_NEGACIDE");
        BLOCK_NAMES.put(TERRAIN_QUANTACIDE_ID, "TERRAIN_QUANTACIDE");
        BLOCK_NAMES.put(TERRAIN_NEGAGATE_ID, "TERRAIN_NEGAGATE");
        BLOCK_NAMES.put(TERRAIN_METATE_ID, "TERRAIN_METATE");
        BLOCK_NAMES.put(TERRAIN_INSANIUM_ID, "TERRAIN_INSANIUM");
        BLOCK_NAMES.put(FACTORY_INPUT_ID, "FACTORY_INPUT");
        BLOCK_NAMES.put(FACTORY_INPUT_ENH_ID, "FACTORY_INPUT_ENH");
        BLOCK_NAMES.put(FACTORY_POWER_CELL_ID, "FACTORY_POWER_CELL");
        BLOCK_NAMES.put(FACTORY_POWER_CELL_ENH_ID, "FACTORY_POWER_CELL_ENH");
        BLOCK_NAMES.put(FACTORY_POWER_COIL_ID, "FACTORY_POWER_COIL");
        BLOCK_NAMES.put(FACTORY_POWER_COIL_ENH_ID, "FACTORY_POWER_COIL_ENH");
        BLOCK_NAMES.put(FACTORY_POWER_BLOCK_ID, "FACTORY_POWER_BLOCK");
        BLOCK_NAMES.put(FACTORY_POWER_BLOCK_ENH_ID, "FACTORY_POWER_BLOCK_ENH");
        BLOCK_NAMES.put(POWER_CELL_ID, "POWER_CELL");
        BLOCK_NAMES.put(POWER_COIL_ID, "POWER_COIL");
        BLOCK_NAMES.put(UNUSED_TEST, "UNUSED_TEST");
        BLOCK_NAMES.put(FACTORY_PARTICLE_PRESS, "FACTORY_PARTICLE_PRESS");
        BLOCK_NAMES.put(MAN_SD1000_CAP, "MAN_SD1000_CAP");
        BLOCK_NAMES.put(MAN_SD2000_CAP, "MAN_SD2000_CAP");
        BLOCK_NAMES.put(MAN_SD3000_CAP, "MAN_SD3000_CAP");
        BLOCK_NAMES.put(MAN_SD1000_FLUX, "MAN_SD1000_FLUX");
        BLOCK_NAMES.put(MAN_SD2000_FLUX, "MAN_SD2000_FLUX");
        BLOCK_NAMES.put(MAN_SD3000_FLUX, "MAN_SD3000_FLUX");
        BLOCK_NAMES.put(MAN_SD1000_MICRO, "MAN_SD1000_MICRO");
        BLOCK_NAMES.put(MAN_SD2000_MICRO, "MAN_SD2000_MICRO");
        BLOCK_NAMES.put(MAN_SD3000_MICRO, "MAN_SD3000_MICRO");
        BLOCK_NAMES.put(MAN_SD1000_DELTA, "MAN_SD1000_DELTA");
        BLOCK_NAMES.put(MAN_SD2000_DELTA, "MAN_SD2000_DELTA");
        BLOCK_NAMES.put(MAN_SD3000_DELTA, "MAN_SD3000_DELTA");
        BLOCK_NAMES.put(MAN_SD1000_MEM, "MAN_SD1000_MEM");
        BLOCK_NAMES.put(MAN_SD2000_MEM, "MAN_SD2000_MEM");
        BLOCK_NAMES.put(MAN_SD3000_MEM, "MAN_SD3000_MEM");
        BLOCK_NAMES.put(MAN_SDPROTON, "MAN_SDPROTON");
        BLOCK_NAMES.put(MAN_RED, "MAN_RED");
        BLOCK_NAMES.put(MAN_PURP, "MAN_PURP");
        BLOCK_NAMES.put(MAN_BROWN, "MAN_BROWN");
        BLOCK_NAMES.put(MAN_GREEN, "MAN_GREEN");
        BLOCK_NAMES.put(MAN_YELLOW, "MAN_YELLOW");
        BLOCK_NAMES.put(MAN_BLACK, "MAN_BLACK");
        BLOCK_NAMES.put(MAN_WHITE, "MAN_WHITE");
        BLOCK_NAMES.put(MAN_BLUE, "MAN_BLUE");
        BLOCK_NAMES.put(MAN_P1000B, "MAN_P1000B");
        BLOCK_NAMES.put(MAN_P2000B, "MAN_P2000B");
        BLOCK_NAMES.put(MAN_P3000B, "MAN_P3000B");
        BLOCK_NAMES.put(MAN_P10000A, "MAN_P10000A");
        BLOCK_NAMES.put(MAN_P20000A, "MAN_P20000A");
        BLOCK_NAMES.put(MAN_P30000A, "MAN_P30000A");
        BLOCK_NAMES.put(MAN_P40000A, "MAN_P40000A");
        BLOCK_NAMES.put(MAN_YHOLE_NUC, "MAN_YHOLE_NUC");
        BLOCK_NAMES.put(FACTORY_SD10000, "FACTORY_SD10000");
        BLOCK_NAMES.put(FACTORY_SD20000, "FACTORY_SD20000");
        BLOCK_NAMES.put(FACTORY_SD30000, "FACTORY_SD30000");
        BLOCK_NAMES.put(FACTORY_SDADV, "FACTORY_SDADV");
        BLOCK_NAMES.put(FACTORY_SD1000, "FACTORY_SD1000");
        BLOCK_NAMES.put(FACTORY_SD2000, "FACTORY_SD2000");
        BLOCK_NAMES.put(FACTORY_SD3000, "FACTORY_SD3000");
        BLOCK_NAMES.put(FACTORY_MINERAL, "FACTORY_MINERAL");
        BLOCK_NAMES.put(POWERHULL_COLOR_GREY, "POWERHULL_COLOR_GREY");
        BLOCK_NAMES.put(POWERHULL_COLOR_BLACK, "POWERHULL_COLOR_BLACK");
        BLOCK_NAMES.put(POWERHULL_COLOR_RED, "POWERHULL_COLOR_RED");
        BLOCK_NAMES.put(POWERHULL_COLOR_PURPLE, "POWERHULL_COLOR_PURPLE");
        BLOCK_NAMES.put(POWERHULL_COLOR_BLUE, "POWERHULL_COLOR_BLUE");
        BLOCK_NAMES.put(POWERHULL_COLOR_GREEN, "POWERHULL_COLOR_GREEN");
        BLOCK_NAMES.put(POWERHULL_COLOR_BROWN, "POWERHULL_COLOR_BROWN");
        BLOCK_NAMES.put(POWERHULL_COLOR_GOLD, "POWERHULL_COLOR_GOLD");
        BLOCK_NAMES.put(POWERHULL_COLOR_WHITE, "POWERHULL_COLOR_WHITE");
        BLOCK_NAMES.put(MAN_GLASS_BOTTLE, "MAN_GLASS_BOTTLE");
        BLOCK_NAMES.put(MAN_SCIENCE_BOTTLE, "MAN_SCIENCE_BOTTLE");
        BLOCK_NAMES.put(TERRAIN_ICEPLANET_SURFACE, "TERRAIN_ICEPLANET_SURFACE");
        BLOCK_NAMES.put(TERRAIN_ICEPLANET_ROCK, "TERRAIN_ICEPLANET_ROCK");
        BLOCK_NAMES.put(TERRAIN_ICEPLANET_WOOD, "TERRAIN_ICEPLANET_WOOD");
        BLOCK_NAMES.put(TERRAIN_ICEPLANET_LEAVES, "TERRAIN_ICEPLANET_LEAVES");
        BLOCK_NAMES.put(TERRAIN_ICEPLANET_SPIKE_SPRITE, "TERRAIN_ICEPLANET_SPIKE_SPRITE");
        BLOCK_NAMES.put(TERRAIN_ICEPLANET_ICECRAG_SPRITE, "TERRAIN_ICEPLANET_ICECRAG_SPRITE");
        BLOCK_NAMES.put(TERRAIN_ICEPLANET_ICECORAL_SPRITE, "TERRAIN_ICEPLANET_ICECORAL_SPRITE");
        BLOCK_NAMES.put(TERRAIN_ICEPLANET_ICEGRASS_SPRITE, "TERRAIN_ICEPLANET_ICEGRASS_SPRITE");
        BLOCK_NAMES.put(LIGHT_RED, "LIGHT_RED");
        BLOCK_NAMES.put(LIGHT_BLUE, "LIGHT_BLUE");
        BLOCK_NAMES.put(LIGHT_GREEN, "LIGHT_GREEN");
        BLOCK_NAMES.put(LIGHT_YELLOW, "LIGHT_YELLOW");
        BLOCK_NAMES.put(TERRAIN_ICEPLANET_CRYSTAL, "TERRAIN_ICEPLANET_CRYSTAL");
        BLOCK_NAMES.put(TERRAIN_REDWOOD, "TERRAIN_REDWOOD");
        BLOCK_NAMES.put(TERRAIN_REDWOOD_LEAVES, "TERRAIN_REDWOOD_LEAVES");
        BLOCK_NAMES.put(FIXED_DOCK_ID, "FIXED_DOCK");
        BLOCK_NAMES.put(FIXED_DOCK_ID_ENHANCER, "FIXED_DOCK_ID_ENHANCER");
        BLOCK_NAMES.put(FACTION_BLOCK, "FACTION_BLOCK");
        BLOCK_NAMES.put(FACTION_HUB_BLOCK, "FACTION_HUB_BLOCK");
        BLOCK_NAMES.put(HULL_COLOR_WEDGE_GREY_ID, "HULL_COLOR_WEDGE_GREY");
        BLOCK_NAMES.put(HULL_COLOR_WEDGE_PURPLE_ID, "HULL_COLOR_WEDGE_PURPLE");
        BLOCK_NAMES.put(HULL_COLOR_WEDGE_BROWN_ID, "HULL_COLOR_WEDGE_BROWN");
        BLOCK_NAMES.put(HULL_COLOR_WEDGE_BLACK_ID, "HULL_COLOR_WEDGE_BLACK");
        BLOCK_NAMES.put(HULL_COLOR_WEDGE_RED_ID, "HULL_COLOR_WEDGE_RED");
        BLOCK_NAMES.put(HULL_COLOR_WEDGE_BLUE_ID, "HULL_COLOR_WEDGE_BLUE");
        BLOCK_NAMES.put(HULL_COLOR_WEDGE_GREEN_ID, "HULL_COLOR_WEDGE_GREEN");
        BLOCK_NAMES.put(HULL_COLOR_WEDGE_YELLOW_ID, "HULL_COLOR_WEDGE_YELLOW");
        BLOCK_NAMES.put(HULL_COLOR_WEDGE_WHITE_ID, "HULL_COLOR_WEDGE_WHITE");
        BLOCK_NAMES.put(HULL_COLOR_CORNER_GREY_ID, "HULL_COLOR_CORNER_GREY");
        BLOCK_NAMES.put(HULL_COLOR_CORNER_PURPLE_ID, "HULL_COLOR_CORNER_PURPLE");
        BLOCK_NAMES.put(HULL_COLOR_CORNER_BROWN_ID, "HULL_COLOR_CORNER_BROWN");
        BLOCK_NAMES.put(HULL_COLOR_CORNER_BLACK_ID, "HULL_COLOR_CORNER_BLACK");
        BLOCK_NAMES.put(HULL_COLOR_CORNER_RED_ID, "HULL_COLOR_CORNER_RED");
        BLOCK_NAMES.put(HULL_COLOR_CORNER_BLUE_ID, "HULL_COLOR_CORNER_BLUE");
        BLOCK_NAMES.put(HULL_COLOR_CORNER_GREEN_ID, "HULL_COLOR_CORNER_GREEN");
        BLOCK_NAMES.put(HULL_COLOR_CORNER_YELLOW_ID, "HULL_COLOR_CORNER_YELLOW");
        BLOCK_NAMES.put(HULL_COLOR_CORNER_WHITE_ID, "HULL_COLOR_CORNER_WHITE");
        BLOCK_NAMES.put(POWERHULL_COLOR_WEDGE_GREY, "POWERHULL_COLOR_WEDGE_GREY");
        BLOCK_NAMES.put(POWERHULL_COLOR_WEDGE_BLACK, "POWERHULL_COLOR_WEDGE_BLACK");
        BLOCK_NAMES.put(POWERHULL_COLOR_WEDGE_RED, "POWERHULL_COLOR_WEDGE_RED");
        BLOCK_NAMES.put(POWERHULL_COLOR_WEDGE_PURPLE, "POWERHULL_COLOR_WEDGE_PURPLE");
        BLOCK_NAMES.put(POWERHULL_COLOR_WEDGE_BLUE, "POWERHULL_COLOR_WEDGE_BLUE");
        BLOCK_NAMES.put(POWERHULL_COLOR_WEDGE_GREEN, "POWERHULL_COLOR_WEDGE_GREEN");
        BLOCK_NAMES.put(POWERHULL_COLOR_WEDGE_BROWN, "POWERHULL_COLOR_WEDGE_BROWN");
        BLOCK_NAMES.put(POWERHULL_COLOR_WEDGE_GOLD, "POWERHULL_COLOR_WEDGE_GOLD");
        BLOCK_NAMES.put(POWERHULL_COLOR_WEDGE_WHITE, "POWERHULL_COLOR_WEDGE_WHITE");
        BLOCK_NAMES.put(POWERHULL_COLOR_CORNER_GREY, "POWERHULL_COLOR_CORNER_GREY");
        BLOCK_NAMES.put(POWERHULL_COLOR_CORNER_BLACK, "POWERHULL_COLOR_CORNER_BLACK");
        BLOCK_NAMES.put(POWERHULL_COLOR_CORNER_RED, "POWERHULL_COLOR_CORNER_RED");
        BLOCK_NAMES.put(POWERHULL_COLOR_CORNER_PURPLE, "POWERHULL_COLOR_CORNER_PURPLE");
        BLOCK_NAMES.put(POWERHULL_COLOR_CORNER_BLUE, "POWERHULL_COLOR_CORNER_BLUE");
        BLOCK_NAMES.put(POWERHULL_COLOR_CORNER_GREEN, "POWERHULL_COLOR_CORNER_GREEN");
        BLOCK_NAMES.put(POWERHULL_COLOR_CORNER_BROWN, "POWERHULL_COLOR_CORNER_BROWN");
        BLOCK_NAMES.put(POWERHULL_COLOR_CORNER_GOLD, "POWERHULL_COLOR_CORNER_GOLD");
        BLOCK_NAMES.put(POWERHULL_COLOR_CORNER_WHITE, "POWERHULL_COLOR_CORNER_WHITE");
        BLOCK_NAMES.put(GLASS_WEDGE_ID, "GLASS_WEDGE");
        BLOCK_NAMES.put(GLASS_CORNER_ID, "GLASS_CORNER");
        BLOCK_NAMES.put(POWER_HOLDER_ID, "POWER_HOLDER");
        BLOCK_NAMES.put(POWER_DRAIN_BEAM_COMPUTER, "POWER_DRAIN_BEAM_COMPUTER");
        BLOCK_NAMES.put(POWER_DRAIN_BEAM_MODULE, "POWER_DRAIN_BEAM_MODULE");
        BLOCK_NAMES.put(POWER_SUPPLY_BEAM_COMPUTER, "POWER_SUPPLY_BEAM_COMPUTER");
        BLOCK_NAMES.put(POWER_SUPPLY_BEAM_MODULE, "POWER_SUPPLY_BEAM_MODULE");
        BLOCK_NAMES.put(DECORATIVE_PANEL_1, "DECORATIVE_PANEL_1");
        BLOCK_NAMES.put(DECORATIVE_PANEL_2, "DECORATIVE_PANEL_2");
        BLOCK_NAMES.put(DECORATIVE_PANEL_3, "DECORATIVE_PANEL_3");
        BLOCK_NAMES.put(DECORATIVE_PANEL_4, "DECORATIVE_PANEL_4");
        BLOCK_NAMES.put(LIGHT_BULB_YELLOW, "LIGHT_BULB_YELLOW");
    }

    public static final Map<Short,String> BLOCK_ABBR = new HashMap<Short, String>();
    static
    {
        BLOCK_ABBR.put((short)0, " ");
        BLOCK_ABBR.put(WEAPON_CONTROLLER_ID, "W");
        BLOCK_ABBR.put(WEAPON_ID, "W");
        BLOCK_ABBR.put(CORE_ID, "C");
        BLOCK_ABBR.put(DEATHSTAR_CORE_ID, "D");
        BLOCK_ABBR.put(GLASS_ID, "G");
        BLOCK_ABBR.put(THRUSTER_ID, "T");
        BLOCK_ABBR.put(DOCK_ID, "D");
        BLOCK_ABBR.put(POWER_ID, "P");
        BLOCK_ABBR.put(SHIELD_ID, "S");
        BLOCK_ABBR.put(EXPLOSIVE_ID, "E");
        BLOCK_ABBR.put(RADAR_JAMMING_ID, "R");
        BLOCK_ABBR.put(CLOAKING_ID, "C");
        BLOCK_ABBR.put(SALVAGE_ID, "S");
        BLOCK_ABBR.put(MISSILE_DUMB_CONTROLLER_ID, "M");
        BLOCK_ABBR.put(MISSILE_DUMB_ID, "M");
        BLOCK_ABBR.put(MISSILE_HEAT_CONTROLLER_ID, "M");
        BLOCK_ABBR.put(MISSILE_HEAT_ID, "M");
        BLOCK_ABBR.put(MISSILE_FAFO_CONTROLLER_ID, "M");
        BLOCK_ABBR.put(MISSILE_FAFO_ID, "M");
        BLOCK_ABBR.put(SALVAGE_CONTROLLER_ID, "S");
        BLOCK_ABBR.put(GRAVITY_ID, "G");
        BLOCK_ABBR.put(REPAIR_ID, "R");
        BLOCK_ABBR.put(REPAIR_CONTROLLER_ID, "R");
        BLOCK_ABBR.put(COCKPIT_ID, "C");
        BLOCK_ABBR.put(LIGHT_ID, "L");
        BLOCK_ABBR.put(LIGHT_BEACON_ID, "L");
        BLOCK_ABBR.put(TERRAIN_ICE_ID, "T");
        BLOCK_ABBR.put(HULL_COLOR_GREY_ID, "H");
        BLOCK_ABBR.put(HULL_COLOR_PURPLE_ID, "H");
        BLOCK_ABBR.put(HULL_COLOR_BROWN_ID, "H");
        BLOCK_ABBR.put(HULL_COLOR_BLACK_ID, "H");
        BLOCK_ABBR.put(HULL_COLOR_RED_ID, "H");
        BLOCK_ABBR.put(HULL_COLOR_BLUE_ID, "H");
        BLOCK_ABBR.put(HULL_COLOR_GREEN_ID, "H");
        BLOCK_ABBR.put(HULL_COLOR_YELLOW_ID, "H");
        BLOCK_ABBR.put(HULL_COLOR_WHITE_ID, "H");
        BLOCK_ABBR.put(LANDING_ELEMENT, "L");
        BLOCK_ABBR.put(LIFT_ELEMENT, "L");
        BLOCK_ABBR.put(RECYCLER_ELEMENT, "R");
        BLOCK_ABBR.put(STASH_ELEMENT, "S");
        BLOCK_ABBR.put(AI_ELEMENT, "A");
        BLOCK_ABBR.put(DOOR_ELEMENT, "D");
        BLOCK_ABBR.put(BUILD_BLOCK_ID, "B");
        BLOCK_ABBR.put(TERRAIN_LAVA_ID, "T");
        BLOCK_ABBR.put(TERRAIN_EXOGEN_ID, "T");
        BLOCK_ABBR.put(TERRAIN_OCTOGEN_ID, "T");
        BLOCK_ABBR.put(TERRAIN_QUANTAGEN_ID, "T");
        BLOCK_ABBR.put(TERRAIN_QUANTANIUM_ID, "T");
        BLOCK_ABBR.put(TERRAIN_PLEXTANIUM_ID, "T");
        BLOCK_ABBR.put(TERRAIN_ORANGUTANIUM_ID, "T");
        BLOCK_ABBR.put(TERRAIN_SUCCUMITE_ID, "T");
        BLOCK_ABBR.put(TERRAIN_CENOMITE_ID, "T");
        BLOCK_ABBR.put(TERRAIN_AWESOMITE_ID, "T");
        BLOCK_ABBR.put(TERRAIN_VAPPECIDE_ID, "T");
        BLOCK_ABBR.put(TERRAIN_MARS_TOP, "T");
        BLOCK_ABBR.put(TERRAIN_MARS_ROCK, "T");
        BLOCK_ABBR.put(TERRAIN_MARS_DIRT, "T");
        BLOCK_ABBR.put(TERRAIN_MARS_TOP_ROCK, "T");
        BLOCK_ABBR.put(TERRAIN_EXTRANIUM_ID, "T");
        BLOCK_ABBR.put(TERRAIN_ROCK_ID, "T");
        BLOCK_ABBR.put(TERRAIN_SAND_ID, "T");
        BLOCK_ABBR.put(TERRAIN_EARTH_TOP_DIRT, "T");
        BLOCK_ABBR.put(TERRAIN_EARTH_TOP_ROCK, "T");
        BLOCK_ABBR.put(TERRAIN_TREE_TRUNK_ID, "T");
        BLOCK_ABBR.put(TERRAIN_TREE_LEAF_ID, "T");
        BLOCK_ABBR.put(TERRAIN_WATER, "T");
        BLOCK_ABBR.put(TERRAIN_DIRT_ID, "T");
        BLOCK_ABBR.put(DOCKING_ENHANCER_ID, "D");
        BLOCK_ABBR.put(TERRAIN_CACTUS_ID, "T");
        BLOCK_ABBR.put(TERRAIN_PURPLE_ALIEN_TOP, "T");
        BLOCK_ABBR.put(TERRAIN_PURPLE_ALIEN_ROCK, "T");
        BLOCK_ABBR.put(TERRAIN_PURPLE_ALIEN_VINE, "T");
        BLOCK_ABBR.put(TERRAIN_GRASS_SPRITE, "T");
        BLOCK_ABBR.put(PLAYER_SPAWN_MODULE, "P");
        BLOCK_ABBR.put(TERRAIN_BROWNWEED_SPRITE, "T");
        BLOCK_ABBR.put(TERRAIN_MARSTENTACLES_SPRITE, "T");
        BLOCK_ABBR.put(TERRAIN_ALIENVINE_SPRITE, "T");
        BLOCK_ABBR.put(TERRAIN_GRASSFLOWERS_SPRITE, "T");
        BLOCK_ABBR.put(TERRAIN_LONGWEED_SPRITE, "T");
        BLOCK_ABBR.put(TERRAIN_TALLSHROOM_SPRITE, "T");
        BLOCK_ABBR.put(TERRAIN_PURSPIRE_SPRITE, "T");
        BLOCK_ABBR.put(TERRAIN_TALLGRASSFLOWERS_SPRITE, "T");
        BLOCK_ABBR.put(TERRAIN_MINICACTUS_SPRITE, "T");
        BLOCK_ABBR.put(TERRAIN_REDSHROOM_SPRITE, "T");
        BLOCK_ABBR.put(TERRAIN_PURPTACLES_SPRITE, "T");
        BLOCK_ABBR.put(TERRAIN_TALLFLOWERS_SPRITE, "T");
        BLOCK_ABBR.put(TERRAIN_ROCK_SPRITE, "T");
        BLOCK_ABBR.put(TERRAIN_ALIENFLOWERS_SPRITE, "T");
        BLOCK_ABBR.put(TERRAIN_YHOLE_SPRITE, "T");
        BLOCK_ABBR.put(TERRAIN_M1L2_ID, "T");
        BLOCK_ABBR.put(TERRAIN_M1L3_ID, "T");
        BLOCK_ABBR.put(TERRAIN_M1L4_ID, "T");
        BLOCK_ABBR.put(TERRAIN_M1L5_ID, "T");
        BLOCK_ABBR.put(TERRAIN_M2L2_ID, "T");
        BLOCK_ABBR.put(TERRAIN_M2L3_ID, "T");
        BLOCK_ABBR.put(TERRAIN_M2L4_ID, "T");
        BLOCK_ABBR.put(TERRAIN_M2L5_ID, "T");
        BLOCK_ABBR.put(TERRAIN_M3L2_ID, "T");
        BLOCK_ABBR.put(TERRAIN_M3L3_ID, "T");
        BLOCK_ABBR.put(TERRAIN_M3L4_ID, "T");
        BLOCK_ABBR.put(TERRAIN_M3L5_ID, "T");
        BLOCK_ABBR.put(TERRAIN_M4L2_ID, "T");
        BLOCK_ABBR.put(TERRAIN_M4L3_ID, "T");
        BLOCK_ABBR.put(TERRAIN_M4L4_ID, "T");
        BLOCK_ABBR.put(TERRAIN_M4L5_ID, "T");
        BLOCK_ABBR.put(TERRAIN_M5L2_ID, "T");
        BLOCK_ABBR.put(TERRAIN_M5L3_ID, "T");
        BLOCK_ABBR.put(TERRAIN_M5L4_ID, "T");
        BLOCK_ABBR.put(TERRAIN_M5L5_ID, "T");
        BLOCK_ABBR.put(TERRAIN_M6L2_ID, "T");
        BLOCK_ABBR.put(TERRAIN_M6L3_ID, "T");
        BLOCK_ABBR.put(TERRAIN_M6L4_ID, "T");
        BLOCK_ABBR.put(TERRAIN_M6L5_ID, "T");
        BLOCK_ABBR.put(TERRAIN_M7L2_ID, "T");
        BLOCK_ABBR.put(TERRAIN_M7L3_ID, "T");
        BLOCK_ABBR.put(TERRAIN_M7L4_ID, "T");
        BLOCK_ABBR.put(TERRAIN_M7L5_ID, "T");
        BLOCK_ABBR.put(TERRAIN_M8L2_ID, "T");
        BLOCK_ABBR.put(TERRAIN_M8L3_ID, "T");
        BLOCK_ABBR.put(TERRAIN_M8L4_ID, "T");
        BLOCK_ABBR.put(TERRAIN_M8L5_ID, "T");
        BLOCK_ABBR.put(TERRAIN_M9L2_ID, "T");
        BLOCK_ABBR.put(TERRAIN_M9L3_ID, "T");
        BLOCK_ABBR.put(TERRAIN_M9L4_ID, "T");
        BLOCK_ABBR.put(TERRAIN_M9L5_ID, "T");
        BLOCK_ABBR.put(TERRAIN_M10L2_ID, "T");
        BLOCK_ABBR.put(TERRAIN_M10L3_ID, "T");
        BLOCK_ABBR.put(TERRAIN_M10L4_ID, "T");
        BLOCK_ABBR.put(TERRAIN_M10L5_ID, "T");
        BLOCK_ABBR.put(TERRAIN_M11L2_ID, "T");
        BLOCK_ABBR.put(TERRAIN_M11L3_ID, "T");
        BLOCK_ABBR.put(TERRAIN_M11L4_ID, "T");
        BLOCK_ABBR.put(TERRAIN_M11L5_ID, "T");
        BLOCK_ABBR.put(TERRAIN_M12L2_ID, "T");
        BLOCK_ABBR.put(TERRAIN_M12L3_ID, "T");
        BLOCK_ABBR.put(TERRAIN_M12L4_ID, "T");
        BLOCK_ABBR.put(TERRAIN_M12L5_ID, "T");
        BLOCK_ABBR.put(TERRAIN_M13L2_ID, "T");
        BLOCK_ABBR.put(TERRAIN_M13L3_ID, "T");
        BLOCK_ABBR.put(TERRAIN_M13L4_ID, "T");
        BLOCK_ABBR.put(TERRAIN_M13L5_ID, "T");
        BLOCK_ABBR.put(TERRAIN_M14L2_ID, "T");
        BLOCK_ABBR.put(TERRAIN_M14L3_ID, "T");
        BLOCK_ABBR.put(TERRAIN_M14L4_ID, "T");
        BLOCK_ABBR.put(TERRAIN_M14L5_ID, "T");
        BLOCK_ABBR.put(TERRAIN_M15L2_ID, "T");
        BLOCK_ABBR.put(TERRAIN_M15L3_ID, "T");
        BLOCK_ABBR.put(TERRAIN_M15L4_ID, "T");
        BLOCK_ABBR.put(TERRAIN_M15L5_ID, "T");
        BLOCK_ABBR.put(TERRAIN_M16L2_ID, "T");
        BLOCK_ABBR.put(TERRAIN_M16L3_ID, "T");
        BLOCK_ABBR.put(TERRAIN_M16L4_ID, "T");
        BLOCK_ABBR.put(TERRAIN_M16L5_ID, "T");
        BLOCK_ABBR.put(TERRAIN_NEGACIDE_ID, "T");
        BLOCK_ABBR.put(TERRAIN_QUANTACIDE_ID, "T");
        BLOCK_ABBR.put(TERRAIN_NEGAGATE_ID, "T");
        BLOCK_ABBR.put(TERRAIN_METATE_ID, "T");
        BLOCK_ABBR.put(TERRAIN_INSANIUM_ID, "T");
        BLOCK_ABBR.put(FACTORY_INPUT_ID, "F");
        BLOCK_ABBR.put(FACTORY_INPUT_ENH_ID, "F");
        BLOCK_ABBR.put(FACTORY_POWER_CELL_ID, "F");
        BLOCK_ABBR.put(FACTORY_POWER_CELL_ENH_ID, "F");
        BLOCK_ABBR.put(FACTORY_POWER_COIL_ID, "F");
        BLOCK_ABBR.put(FACTORY_POWER_COIL_ENH_ID, "F");
        BLOCK_ABBR.put(FACTORY_POWER_BLOCK_ID, "F");
        BLOCK_ABBR.put(FACTORY_POWER_BLOCK_ENH_ID, "F");
        BLOCK_ABBR.put(POWER_CELL_ID, "P");
        BLOCK_ABBR.put(POWER_COIL_ID, "P");
        BLOCK_ABBR.put(UNUSED_TEST, "U");
        BLOCK_ABBR.put(FACTORY_PARTICLE_PRESS, "F");
        BLOCK_ABBR.put(MAN_SD1000_CAP, "M");
        BLOCK_ABBR.put(MAN_SD2000_CAP, "M");
        BLOCK_ABBR.put(MAN_SD3000_CAP, "M");
        BLOCK_ABBR.put(MAN_SD1000_FLUX, "M");
        BLOCK_ABBR.put(MAN_SD2000_FLUX, "M");
        BLOCK_ABBR.put(MAN_SD3000_FLUX, "M");
        BLOCK_ABBR.put(MAN_SD1000_MICRO, "M");
        BLOCK_ABBR.put(MAN_SD2000_MICRO, "M");
        BLOCK_ABBR.put(MAN_SD3000_MICRO, "M");
        BLOCK_ABBR.put(MAN_SD1000_DELTA, "M");
        BLOCK_ABBR.put(MAN_SD2000_DELTA, "M");
        BLOCK_ABBR.put(MAN_SD3000_DELTA, "M");
        BLOCK_ABBR.put(MAN_SD1000_MEM, "M");
        BLOCK_ABBR.put(MAN_SD2000_MEM, "M");
        BLOCK_ABBR.put(MAN_SD3000_MEM, "M");
        BLOCK_ABBR.put(MAN_SDPROTON, "M");
        BLOCK_ABBR.put(MAN_RED, "M");
        BLOCK_ABBR.put(MAN_PURP, "M");
        BLOCK_ABBR.put(MAN_BROWN, "M");
        BLOCK_ABBR.put(MAN_GREEN, "M");
        BLOCK_ABBR.put(MAN_YELLOW, "M");
        BLOCK_ABBR.put(MAN_BLACK, "M");
        BLOCK_ABBR.put(MAN_WHITE, "M");
        BLOCK_ABBR.put(MAN_BLUE, "M");
        BLOCK_ABBR.put(MAN_P1000B, "M");
        BLOCK_ABBR.put(MAN_P2000B, "M");
        BLOCK_ABBR.put(MAN_P3000B, "M");
        BLOCK_ABBR.put(MAN_P10000A, "M");
        BLOCK_ABBR.put(MAN_P20000A, "M");
        BLOCK_ABBR.put(MAN_P30000A, "M");
        BLOCK_ABBR.put(MAN_P40000A, "M");
        BLOCK_ABBR.put(MAN_YHOLE_NUC, "M");
        BLOCK_ABBR.put(FACTORY_SD10000, "F");
        BLOCK_ABBR.put(FACTORY_SD20000, "F");
        BLOCK_ABBR.put(FACTORY_SD30000, "F");
        BLOCK_ABBR.put(FACTORY_SDADV, "F");
        BLOCK_ABBR.put(FACTORY_SD1000, "F");
        BLOCK_ABBR.put(FACTORY_SD2000, "F");
        BLOCK_ABBR.put(FACTORY_SD3000, "F");
        BLOCK_ABBR.put(FACTORY_MINERAL, "F");
        BLOCK_ABBR.put(POWERHULL_COLOR_GREY, "P");
        BLOCK_ABBR.put(POWERHULL_COLOR_BLACK, "P");
        BLOCK_ABBR.put(POWERHULL_COLOR_RED, "P");
        BLOCK_ABBR.put(POWERHULL_COLOR_PURPLE, "P");
        BLOCK_ABBR.put(POWERHULL_COLOR_BLUE, "P");
        BLOCK_ABBR.put(POWERHULL_COLOR_GREEN, "P");
        BLOCK_ABBR.put(POWERHULL_COLOR_BROWN, "P");
        BLOCK_ABBR.put(POWERHULL_COLOR_GOLD, "P");
        BLOCK_ABBR.put(POWERHULL_COLOR_WHITE, "P");
        BLOCK_ABBR.put(MAN_GLASS_BOTTLE, "M");
        BLOCK_ABBR.put(MAN_SCIENCE_BOTTLE, "M");
        BLOCK_ABBR.put(TERRAIN_ICEPLANET_SURFACE, "T");
        BLOCK_ABBR.put(TERRAIN_ICEPLANET_ROCK, "T");
        BLOCK_ABBR.put(TERRAIN_ICEPLANET_WOOD, "T");
        BLOCK_ABBR.put(TERRAIN_ICEPLANET_LEAVES, "T");
        BLOCK_ABBR.put(TERRAIN_ICEPLANET_SPIKE_SPRITE, "T");
        BLOCK_ABBR.put(TERRAIN_ICEPLANET_ICECRAG_SPRITE, "T");
        BLOCK_ABBR.put(TERRAIN_ICEPLANET_ICECORAL_SPRITE, "T");
        BLOCK_ABBR.put(TERRAIN_ICEPLANET_ICEGRASS_SPRITE, "T");
        BLOCK_ABBR.put(LIGHT_RED, "L");
        BLOCK_ABBR.put(LIGHT_BLUE, "L");
        BLOCK_ABBR.put(LIGHT_GREEN, "L");
        BLOCK_ABBR.put(LIGHT_YELLOW, "L");
        BLOCK_ABBR.put(TERRAIN_ICEPLANET_CRYSTAL, "T");
        BLOCK_ABBR.put(TERRAIN_REDWOOD, "T");
        BLOCK_ABBR.put(TERRAIN_REDWOOD_LEAVES, "T");
        BLOCK_ABBR.put(FIXED_DOCK_ID, "F");
        BLOCK_ABBR.put(FIXED_DOCK_ID_ENHANCER, "F");
        BLOCK_ABBR.put(FACTION_BLOCK, "F");
        BLOCK_ABBR.put(FACTION_HUB_BLOCK, "F");
        BLOCK_ABBR.put(HULL_COLOR_WEDGE_GREY_ID, "H");
        BLOCK_ABBR.put(HULL_COLOR_WEDGE_PURPLE_ID, "H");
        BLOCK_ABBR.put(HULL_COLOR_WEDGE_BROWN_ID, "H");
        BLOCK_ABBR.put(HULL_COLOR_WEDGE_BLACK_ID, "H");
        BLOCK_ABBR.put(HULL_COLOR_WEDGE_RED_ID, "H");
        BLOCK_ABBR.put(HULL_COLOR_WEDGE_BLUE_ID, "H");
        BLOCK_ABBR.put(HULL_COLOR_WEDGE_GREEN_ID, "H");
        BLOCK_ABBR.put(HULL_COLOR_WEDGE_YELLOW_ID, "H");
        BLOCK_ABBR.put(HULL_COLOR_WEDGE_WHITE_ID, "H");
        BLOCK_ABBR.put(HULL_COLOR_CORNER_GREY_ID, "H");
        BLOCK_ABBR.put(HULL_COLOR_CORNER_PURPLE_ID, "H");
        BLOCK_ABBR.put(HULL_COLOR_CORNER_BROWN_ID, "H");
        BLOCK_ABBR.put(HULL_COLOR_CORNER_BLACK_ID, "H");
        BLOCK_ABBR.put(HULL_COLOR_CORNER_RED_ID, "H");
        BLOCK_ABBR.put(HULL_COLOR_CORNER_BLUE_ID, "H");
        BLOCK_ABBR.put(HULL_COLOR_CORNER_GREEN_ID, "H");
        BLOCK_ABBR.put(HULL_COLOR_CORNER_YELLOW_ID, "H");
        BLOCK_ABBR.put(HULL_COLOR_CORNER_WHITE_ID, "H");
        BLOCK_ABBR.put(POWERHULL_COLOR_WEDGE_GREY, "P");
        BLOCK_ABBR.put(POWERHULL_COLOR_WEDGE_BLACK, "P");
        BLOCK_ABBR.put(POWERHULL_COLOR_WEDGE_RED, "P");
        BLOCK_ABBR.put(POWERHULL_COLOR_WEDGE_PURPLE, "P");
        BLOCK_ABBR.put(POWERHULL_COLOR_WEDGE_BLUE, "P");
        BLOCK_ABBR.put(POWERHULL_COLOR_WEDGE_GREEN, "P");
        BLOCK_ABBR.put(POWERHULL_COLOR_WEDGE_BROWN, "P");
        BLOCK_ABBR.put(POWERHULL_COLOR_WEDGE_GOLD, "P");
        BLOCK_ABBR.put(POWERHULL_COLOR_WEDGE_WHITE, "P");
        BLOCK_ABBR.put(POWERHULL_COLOR_CORNER_GREY, "P");
        BLOCK_ABBR.put(POWERHULL_COLOR_CORNER_BLACK, "P");
        BLOCK_ABBR.put(POWERHULL_COLOR_CORNER_RED, "P");
        BLOCK_ABBR.put(POWERHULL_COLOR_CORNER_PURPLE, "P");
        BLOCK_ABBR.put(POWERHULL_COLOR_CORNER_BLUE, "P");
        BLOCK_ABBR.put(POWERHULL_COLOR_CORNER_GREEN, "P");
        BLOCK_ABBR.put(POWERHULL_COLOR_CORNER_BROWN, "P");
        BLOCK_ABBR.put(POWERHULL_COLOR_CORNER_GOLD, "P");
        BLOCK_ABBR.put(POWERHULL_COLOR_CORNER_WHITE, "P");
        BLOCK_ABBR.put(GLASS_WEDGE_ID, "G");
        BLOCK_ABBR.put(GLASS_CORNER_ID, "G");
        BLOCK_ABBR.put(POWER_HOLDER_ID, "P");
        BLOCK_ABBR.put(POWER_DRAIN_BEAM_COMPUTER, "P");
        BLOCK_ABBR.put(POWER_DRAIN_BEAM_MODULE, "P");
        BLOCK_ABBR.put(POWER_SUPPLY_BEAM_COMPUTER, "P");
        BLOCK_ABBR.put(POWER_SUPPLY_BEAM_MODULE, "P");
        BLOCK_ABBR.put(DECORATIVE_PANEL_1, "D");
        BLOCK_ABBR.put(DECORATIVE_PANEL_2, "D");
        BLOCK_ABBR.put(DECORATIVE_PANEL_3, "D");
        BLOCK_ABBR.put(DECORATIVE_PANEL_4, "D");
        BLOCK_ABBR.put(LIGHT_BULB_YELLOW, "L");
    }
    
    public static final int HULL_COLORS = 0;
    public static final int WEDGE_COLORS = 1;
    public static final int CORNER_COLORS = 2;
    public static final int POWERHULL_COLORS = 3;
    public static final int POWERWEDGE_COLORS = 4;
    public static final int POWERCORNER_COLORS = 5;
    
    public static short[][] HULL_COLOR_MAP = {
    	{ 	// hulls
	        HULL_COLOR_GREY_ID,
	        HULL_COLOR_PURPLE_ID,
	        HULL_COLOR_BROWN_ID,
	        HULL_COLOR_BLACK_ID,
	        HULL_COLOR_RED_ID,
	        HULL_COLOR_BLUE_ID,
	        HULL_COLOR_GREEN_ID,
	        HULL_COLOR_YELLOW_ID,
	        HULL_COLOR_WHITE_ID,
		},
		{ 	// wedges
	        HULL_COLOR_WEDGE_GREY_ID, 
	        HULL_COLOR_WEDGE_PURPLE_ID, 
	        HULL_COLOR_WEDGE_BROWN_ID, 
	        HULL_COLOR_WEDGE_BLACK_ID, 
	        HULL_COLOR_WEDGE_RED_ID, 
	        HULL_COLOR_WEDGE_BLUE_ID, 
	        HULL_COLOR_WEDGE_GREEN_ID, 
	        HULL_COLOR_WEDGE_YELLOW_ID, 
	        HULL_COLOR_WEDGE_WHITE_ID, 
		},
		{ 	// corners
	        HULL_COLOR_CORNER_GREY_ID, 
	        HULL_COLOR_CORNER_PURPLE_ID, 
	        HULL_COLOR_CORNER_BROWN_ID, 
	        HULL_COLOR_CORNER_BLACK_ID, 
	        HULL_COLOR_CORNER_RED_ID, 
	        HULL_COLOR_CORNER_BLUE_ID, 
	        HULL_COLOR_CORNER_GREEN_ID, 
	        HULL_COLOR_CORNER_YELLOW_ID, 
	        HULL_COLOR_CORNER_WHITE_ID, 
		},
    	{ 	// power hulls
	        POWERHULL_COLOR_GREY,
	        POWERHULL_COLOR_PURPLE,
	        POWERHULL_COLOR_BROWN,
	        POWERHULL_COLOR_BLACK,
	        POWERHULL_COLOR_RED,
	        POWERHULL_COLOR_BLUE,
	        POWERHULL_COLOR_GREEN,
	        POWERHULL_COLOR_GOLD,
	        POWERHULL_COLOR_WHITE,
		},
    	{ 	// power wedges
	        POWERHULL_COLOR_WEDGE_GREY, 
	        POWERHULL_COLOR_WEDGE_PURPLE, 
	        POWERHULL_COLOR_WEDGE_BROWN, 
	        POWERHULL_COLOR_WEDGE_BLACK, 
	        POWERHULL_COLOR_WEDGE_RED, 
	        POWERHULL_COLOR_WEDGE_BLUE, 
	        POWERHULL_COLOR_WEDGE_GREEN, 
	        POWERHULL_COLOR_WEDGE_GOLD, 
	        POWERHULL_COLOR_WEDGE_WHITE, 
		},
    	{ 	// power corners
	        POWERHULL_COLOR_CORNER_GREY, 
	        POWERHULL_COLOR_CORNER_PURPLE, 
	        POWERHULL_COLOR_CORNER_BROWN, 
	        POWERHULL_COLOR_CORNER_BLACK, 
	        POWERHULL_COLOR_CORNER_RED, 
	        POWERHULL_COLOR_CORNER_BLUE, 
	        POWERHULL_COLOR_CORNER_GREEN, 
	        POWERHULL_COLOR_CORNER_GOLD, 
	        POWERHULL_COLOR_CORNER_WHITE, 
    	},
    };
    
    private static int indexOf(short[] array, short val)
    {
    	for (int i = 0; i < array.length; i++)
    		if (array[i] == val)
    			return i;
    	return -1;
    }
    
    public static boolean isHull(short blockID)
    {
    	return indexOf(HULL_COLOR_MAP[HULL_COLORS], blockID) >= 0;
    }
    public static boolean isWedge(short blockID)
    {
    	return indexOf(HULL_COLOR_MAP[WEDGE_COLORS], blockID) >= 0;
    }
    public static boolean isCorner(short blockID)
    {
    	return indexOf(HULL_COLOR_MAP[CORNER_COLORS], blockID) >= 0;
    }
    public static boolean isPowerHull(short blockID)
    {
    	return indexOf(HULL_COLOR_MAP[POWERHULL_COLORS], blockID) >= 0;
    }
    public static boolean isPowerWedge(short blockID)
    {
    	return indexOf(HULL_COLOR_MAP[POWERWEDGE_COLORS], blockID) >= 0;
    }
    public static boolean isPowerCorner(short blockID)
    {
    	return indexOf(HULL_COLOR_MAP[POWERCORNER_COLORS], blockID) >= 0;
    }
    
    public static short getColoredBlock(short blockID, short colorID)
    {
    	int idx = indexOf(HULL_COLOR_MAP[HULL_COLORS], colorID);
    	if (idx < 0)
    		throw new IllegalArgumentException("Color must be a hull ID: "+colorID);
    	short newBlockID = -1;
    	if (isHull(blockID))
    		newBlockID = HULL_COLOR_MAP[HULL_COLORS][idx];
    	else if (isWedge(blockID))
    		newBlockID = HULL_COLOR_MAP[WEDGE_COLORS][idx];
    	else if (isCorner(blockID))
    		newBlockID = HULL_COLOR_MAP[CORNER_COLORS][idx];
    	else if (isPowerHull(blockID))
    		newBlockID = HULL_COLOR_MAP[POWERHULL_COLORS][idx];
    	else if (isPowerWedge(blockID))
    		newBlockID = HULL_COLOR_MAP[POWERWEDGE_COLORS][idx];
    	else if (isPowerCorner(blockID))
    		newBlockID = HULL_COLOR_MAP[POWERCORNER_COLORS][idx];
    	return newBlockID;
    }
    
    public static short getPoweredBlock(short blockID)
    {
    	int idx = indexOf(HULL_COLOR_MAP[HULL_COLORS], blockID);
    	if (idx >= 0)
    		return HULL_COLOR_MAP[POWERHULL_COLORS][idx];
    	idx = indexOf(HULL_COLOR_MAP[WEDGE_COLORS], blockID);
    	if (idx >= 0)
    		return HULL_COLOR_MAP[POWERWEDGE_COLORS][idx];
    	idx = indexOf(HULL_COLOR_MAP[CORNER_COLORS], blockID);
    	if (idx >= 0)
    		return HULL_COLOR_MAP[POWERCORNER_COLORS][idx];
    	return -1;
    }
    
    public static short getUnPoweredBlock(short blockID)
    {
    	int idx = indexOf(HULL_COLOR_MAP[POWERHULL_COLORS], blockID);
    	if (idx >= 0)
    		return HULL_COLOR_MAP[HULL_COLORS][idx];
    	idx = indexOf(HULL_COLOR_MAP[POWERWEDGE_COLORS], blockID);
    	if (idx >= 0)
    		return HULL_COLOR_MAP[WEDGE_COLORS][idx];
    	idx = indexOf(HULL_COLOR_MAP[POWERCORNER_COLORS], blockID);
    	if (idx >= 0)
    		return HULL_COLOR_MAP[CORNER_COLORS][idx];
    	return -1;
    }

    public static boolean isAnyHull(short blockID)
    {
        if (isHull(blockID) || isCorner(blockID) || isWedge(blockID) 
                || isPowerHull(blockID) || isPowerCorner(blockID) || isPowerWedge(blockID))
            return true;
        return false;
    }
}
