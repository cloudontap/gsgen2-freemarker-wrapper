package io.codeontap.freemarkerwrapper;

import freemarker.template.*;

import javax.json.JsonString;
import javax.json.JsonValue;

public class JsonStringAdapter extends WrappingTemplateModel implements TemplateScalarModel,
        AdapterTemplateModel {

    private final JsonString jsonString;

    public JsonStringAdapter(JsonString jsonString, ObjectWrapper ow) {
        super(ow);  // coming from WrappingTemplateModel
        this.jsonString = jsonString;
    }

    @Override  // coming from AdapterTemplateModel
    public Object getAdaptedObject(Class hint) {
        return jsonString.getString();
    }

    @Override
    public String getAsString() throws TemplateModelException {
        return jsonString.getString();
    }
}
