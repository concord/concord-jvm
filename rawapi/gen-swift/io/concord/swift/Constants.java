package com.concord.swift;

import com.facebook.swift.codec.*;
import com.google.common.collect.*;
import java.util.*;

public final class Constants
{
    private Constants() {
    }

    public static final String kBoltDefaultEnvBasePath = "/tmp/";

    public static final String kBoltEnvKeyBasePath = "BOLT_BASE_PATH";

    public static final String kBoltEnvKeyPathPrefix = "BOLT";

    public static final String kBoltTraceHeader = "bolt_traces";

    public static final String kConcordEnvKeyClientListenAddr = "CONCORD_client_listen_address";

    public static final String kConcordEnvKeyClientProxyAddr = "CONCORD_client_proxy_address";

    public static final int kDatabaseEntryTTL = 43200;

    public static final String kDatabasePath = "/tmp";

    public static final int kDefaultBatchSize = 2048;

    public static final int kDefaultThriftServiceIOThreads = 2;

    public static final int kDefaultTraceSampleEveryN = 1024;

    public static final String kIncomingMessageQueueTopic = "incoming";

    public static final int kMessageQueueBatchSize = 1024;

    public static final int kMessageQueueTTL = 21600;

    public static final String kMessageQueueWatermarkTopic = "watermarks";

    public static final String kOutgoingMessageQueueTopic = "outgoing";

    public static final String kPrincipalComputationName = "principal_computation";

    public static final String kPrincipalTimerQueueTopic = "principal_timers";

    public static final String kQueueStreamNameToIdMapTopic = "stream_map";
}
