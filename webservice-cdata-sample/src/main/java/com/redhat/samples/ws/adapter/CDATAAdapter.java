package com.redhat.samples.ws.adapter;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class CDATAAdapter extends XmlAdapter<String, String> {

    public CDATAAdapter() {
        // TODO Auto-generated constructor stub
    }

    @Override
    public String marshal(String data) throws Exception {
        return "<![CDATA[" + data + "]]>";
    }

    @Override
    public String unmarshal(String data) throws Exception {
        return data;
    }

}
