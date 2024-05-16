package com.ramostear.una.saas.resources;

import com.ramostear.una.saas.master.model.MasterTenant;
import com.ramostear.una.saas.master.service.MasterTenantService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import javax.validation.Valid;
import java.sql.SQLException;

@RestController
@RequestMapping(value = "/api/tenant")
public class MasterTenantResource {

    private final MasterTenantService masterTenantService;
    private final DataSource dataSource;

    public MasterTenantResource(MasterTenantService masterTenantService, DataSource dataSource) {
        this.masterTenantService = masterTenantService;
        this.dataSource = dataSource;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    public ResponseEntity<MasterTenant> create(@RequestBody @Valid MasterTenant tenant) throws SQLException {
        System.out.println(dataSource.getConnection().getSchema());
        return ResponseEntity.ok(this.masterTenantService.create(tenant));
    }

}
