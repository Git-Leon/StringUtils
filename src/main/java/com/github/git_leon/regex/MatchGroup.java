package com.github.git_leon.regex;

import com.github.git_leon.collectionutils.ListFacade;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;

public class MatchGroup extends ListFacade<Match> {
    private final Matcher matcher;

    public MatchGroup(List<Match> matchList, Matcher matcher) {
        super(matchList);
        this.matcher = matcher;
        this.initializeMatchers();
    }

    public MatchGroup(Matcher matcher) {
        this(new ArrayList<>(), matcher);
    }

    public Matcher getMatcher() {
        return matcher;
    }

    private void initializeMatchers() {
        for (int i = 0; matcher.find(); i++) {
            super.add(new MatchBuilder()
                    .setStartingIndex(matcher.start())
                    .setEndingIndex(matcher.end())
                    .setValue(matcher.group())
                    .setMatchNumber(i)
                    .build());
        }
    }
}