package com.example.security;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class SecurityController {
@GetMapping(path = "/erros")
public String erros()
{
return "erros";	
}
}
