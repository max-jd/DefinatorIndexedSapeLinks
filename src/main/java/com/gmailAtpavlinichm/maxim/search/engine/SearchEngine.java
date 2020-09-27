package com.gmailAtpavlinichm.maxim.search.engine;

import java.util.Map;

public interface SearchEngine {
    boolean search(Map.Entry<String, String> entryForSearch);
}
