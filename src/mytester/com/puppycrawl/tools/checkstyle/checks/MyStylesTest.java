package com.puppycrawl.tools.checkstyle.checks;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.Test;

import com.puppycrawl.tools.checkstyle.BaseCheckTestSupport;
import com.puppycrawl.tools.checkstyle.DefaultConfiguration;
import com.puppycrawl.tools.checkstyle.checks.naming.AbstractClassNameCheck;

public class MyStylesTest extends BaseCheckTestSupport{

    @Test
    public void testIllegalAbstractClassName() throws Exception
    {
        final DefaultConfiguration checkConfig =
            createCheckConfig(AbstractClassNameCheck.class);
        checkConfig.addAttribute("ignoreName", "false");
        checkConfig.addAttribute("ignoreModifier", "true");

        final String[] expected = {
            "3:1: Name 'InputAbstractClassName' must match pattern '^Abstract.*$|^.*Factory$'.",
            "6:1: Name 'NonAbstractClassName' must match pattern '^Abstract.*$|^.*Factory$'.",
            "9:1: Name 'FactoryWithBadName' must match pattern '^Abstract.*$|^.*Factory$'.",
            "13:5: Name 'NonAbstractInnerClass' must match pattern '^Abstract.*$|^.*Factory$'.",
        };


        verify(checkConfig, getPath("my" + File.separator + "InputAbstractClassName.java"), expected);
    }
}
