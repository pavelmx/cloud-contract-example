package com.innowise.contract.features;


import jdk.jfr.Label;
import org.togglz.core.Feature;
import org.togglz.core.annotation.EnabledByDefault;


public enum MyFeatures implements Feature {

    @EnabledByDefault
    @Label("First Feature")
    FEATURE_ONE,

    @Label("Second Feature")
    FEATURE_TWO;

}
