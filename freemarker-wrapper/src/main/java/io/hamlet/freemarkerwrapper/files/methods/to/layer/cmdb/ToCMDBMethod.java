package io.hamlet.freemarkerwrapper.files.methods.to.layer.cmdb;

import freemarker.core.Environment;
import freemarker.template.*;
import io.hamlet.freemarkerwrapper.files.meta.layer.cmdb.CMDBMeta;
import io.hamlet.freemarkerwrapper.files.methods.to.layer.ToLayerMethod;
import io.hamlet.freemarkerwrapper.files.processors.layer.cmdb.CMDBProcessor;
import io.hamlet.freemarkerwrapper.utils.FreemarkerUtil;

import java.util.List;
import java.util.Map;

public class ToCMDBMethod extends ToLayerMethod implements TemplateMethodModelEx {

    public static String METHOD_NAME = "toCMDB";

    public ToCMDBMethod() {
        super(3, METHOD_NAME);
    }

    @Override
    protected void init() {
        meta = new CMDBMeta();
        processor = new CMDBProcessor();
    }

    @Override
    protected void parseArguments(List args) throws TemplateModelException {
        String path = FreemarkerUtil.getOptionStringValue(args.get(0));
        Object contentObj = FreemarkerUtil.ftlVarToCoreJavaObject((TemplateModel) args.get(1));
        List<String> lookupDirs = (List<String>) ((DefaultListAdapter) Environment.getCurrentEnvironment().getGlobalVariable("lookupDirs")).getWrappedObject();
        List<String> CMDBNames = (List<String>) ((DefaultListAdapter) Environment.getCurrentEnvironment().getGlobalVariable("CMDBNames")).getWrappedObject();
        Map<String, String> cmdbPathMapping = (Map<String, String>) ((DefaultMapAdapter) Environment.getCurrentEnvironment().getGlobalVariable("cmdbPathMappings")).getWrappedObject();
        String baseCMDB = ((SimpleScalar) Environment.getCurrentEnvironment().getGlobalVariable("baseCMDB")).getAsString();
        TemplateHashModelEx options = (TemplateHashModelEx) args.get(2);
        TemplateModelIterator iterator = options.keys().iterator();
        boolean append = Boolean.FALSE;
        boolean sync = Boolean.TRUE;
        String format = "json";
        String formatting = "compressed";
        Number indent = 2;
        while (iterator.hasNext()) {
            TemplateModel keyModel = iterator.next();
            String key = keyModel.toString();
            Object keyObj = options.get(key);
            if ("Append".equalsIgnoreCase(key)) {
                append = FreemarkerUtil.getOptionBooleanValue(keyObj);
            } else if ("Synch".equalsIgnoreCase(key)) {
                sync = FreemarkerUtil.getOptionBooleanValue(keyObj);
            } else if ("Format".equalsIgnoreCase(key)) {
                format = FreemarkerUtil.getOptionStringValue(keyObj);
            } else if ("Formatting".equalsIgnoreCase(key)) {
                formatting = FreemarkerUtil.getOptionStringValue(keyObj);
            } else if ("Indent".equalsIgnoreCase(key)) {
                indent = FreemarkerUtil.getOptionNumberValue(keyObj);
            }
        }
        CMDBMeta cmdbMeta = (CMDBMeta) meta;
        cmdbMeta.setToPath(path);
        cmdbMeta.setLookupDirs(lookupDirs);
        cmdbMeta.setCMDBs(cmdbPathMapping);
        cmdbMeta.setCMDBNamesList(CMDBNames);
        cmdbMeta.setBaseCMDB(baseCMDB);
        cmdbMeta.setAppend(append);
        cmdbMeta.setSync(sync);
        cmdbMeta.setFormat(format);
        cmdbMeta.setContent(contentObj);
        cmdbMeta.setFormatting(formatting);
        cmdbMeta.setIndent(indent.intValue());
    }
}
