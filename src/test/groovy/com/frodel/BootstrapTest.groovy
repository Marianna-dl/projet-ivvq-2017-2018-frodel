package com.frodel

import com.frodel.services.InitialisationService
import spock.lang.Specification

class BootstrapTest extends Specification {

    void "test initialisation service in bootstrap"() {

        given: "a correctly initialized bootstrap"
        Bootstrap bootstrap = new Bootstrap()
        bootstrap.initialisationService = Mock(InitialisationService)

        when: "the init method is triggered"
        bootstrap.init()

        then: "the initialisation is triggered on the initialisation service"
        1 * bootstrap.initialisationService.initData();

    }
}