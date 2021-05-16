package ${featurePackage}.${modelPackage}.service.impl;

import ${featurePackage}.${modelPackage}.mapper.${modelNameUpperCamel}Mapper;
import ${featurePackage}.${modelPackage}.model.${modelNameUpperCamel};
import ${featurePackage}.${modelPackage}.service.${modelNameUpperCamel}Service;
import ${basePackage}.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.annotation.Resource;


/**
 * Created by ${author} on ${date}.
 */
@Service
@Transactional
public class ${modelNameUpperCamel}ServiceImpl extends AbstractService<${modelNameUpperCamel}> implements ${modelNameUpperCamel}Service {

    Logger logger = LoggerFactory.getLogger(${modelNameUpperCamel}ServiceImpl.class);

    @Resource
    private ${modelNameUpperCamel}Mapper ${modelNameLowerCamel}Mapper;

}
