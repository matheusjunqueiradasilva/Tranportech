package com.TransporTech.interfaces

import com.TransporTech.domain.ClienteRepository
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.RestController

@Service
@RestController

class clienteApi(
    val clienteRepository : ClienteRepository
){






}