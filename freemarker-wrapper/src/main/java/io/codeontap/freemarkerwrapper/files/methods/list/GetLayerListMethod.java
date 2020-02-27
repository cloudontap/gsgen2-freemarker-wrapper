package io.codeontap.freemarkerwrapper.files.methods.list;

import freemarker.core.Environment;
import freemarker.template.*;
import io.codeontap.freemarkerwrapper.RunFreeMarkerException;
import io.codeontap.freemarkerwrapper.files.meta.LayerMeta;
import io.codeontap.freemarkerwrapper.files.processors.LayerProcessor;

import javax.json.JsonArray;

public abstract class GetLayerListMethod {

    protected LayerMeta meta;
    protected LayerProcessor layerProcessor;

    public TemplateModel process() {
        layerProcessor.setConfiguration(Environment.getCurrentEnvironment().getConfiguration());
        JsonArray result = null;
        try {
            result = layerProcessor.getLayers(meta);
        } catch (RunFreeMarkerException e) {
            e.printStackTrace();
        }
        return new SimpleSequence(result, Environment.getCurrentEnvironment().getConfiguration().getObjectWrapper());
    }
}
