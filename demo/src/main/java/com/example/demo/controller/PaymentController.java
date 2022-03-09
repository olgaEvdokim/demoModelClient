package com.example.demo.controller;

import com.example.demo.dto.PayloadDto;
import com.example.demo.dto.PayloadRequest;
import com.example.demo.service.PaymentService;
import com.example.demo.util.TransformerUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(final PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @GetMapping("/payment")
    public ModelAndView createPayment() {
        return new ModelAndView("redirect:/auth/signIn");
    }

    @PostMapping("/payment-request")
    @ResponseBody
    public String acceptPaymentRequest(@ModelAttribute("modelPayloadDto") final PayloadDto payloadDto, Model model) {
        final PayloadDto dto = (PayloadDto) model.getAttribute("modelPayloadDto");
        final PayloadRequest payloadRequest = TransformerUtil.buildPayload(dto);
        return paymentService.acceptPayment(payloadDto.getAccessToken(), payloadRequest);
    }

}
