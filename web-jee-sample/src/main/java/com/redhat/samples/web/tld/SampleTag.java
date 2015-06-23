package com.redhat.samples.web.tld;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class SampleTag extends TagSupport {

    public SampleTag() {
        // TODO Auto-generated constructor stub
    }

    @Override
    public int doStartTag() throws JspException {

        try {
            // Get the writer object for output.
            JspWriter out = this.pageContext.getOut();

            out.println("Sample Tag is it working");
        } catch (IOException e) {
            e.printStackTrace();
        }

        return SKIP_BODY;
    }

}
