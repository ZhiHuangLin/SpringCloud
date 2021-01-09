package com.wecon.springcloud.service;

import com.wecon.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
/**
 * @author zhl
 */
@Mapper
public interface PaymentService {
     int create(Payment payment);

     Payment getPaymentById(@Param("id") Long id);
}
