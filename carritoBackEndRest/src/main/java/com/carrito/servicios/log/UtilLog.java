package com.carrito.servicios.log;
//package com.dinersclub.servicios.log;
//
//import java.util.Date;
//
//import org.slf4j.Logger;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.jms.core.JmsTemplate;
//import org.springframework.stereotype.Service;
//
//import com.fasterxml.jackson.core.JsonProcessingException;
//
//import com.dinersclub.servicios.bean.BeanLog;
//import com.dinersclub.servicios.util.Globales;
//import com.dinersclub.servicios.util.UtilDate;
//import com.dinersclub.servicios.util.UtilObjectMapper;
//
///*ESCRIBIR EN ESTA CLASE LA LOGICA PARA ENCRIBIR LOG*/
//@Service
//public class UtilLog {
//
//	@Autowired
//	private JmsTemplate jmsTemplate;
//
//	@Value("${spring.application.name}")
//	private String appName;
//
//	public void printInfo(Logger logger, BeanLog beanLog) {
//		new Thread(new Runnable() {
//			@Override
//			public void run() {
//				String[] splitFechaActual = UtilDate.convertDateToString(new Date(), UtilDate.formatDateYYYYMMDD_HHMMSS)
//						.split("_");
//				beanLog.setFechaRegistro(splitFechaActual[0]);
//				beanLog.setHoraRegistro(splitFechaActual[1]);
//				beanLog.setAplicacion(appName);
//				try {
//					logger.info(UtilObjectMapper.getObjectMapper().writeValueAsString(beanLog));
//					jmsTemplate.convertAndSend(Globales.JmsColaLogEnvio,
//							UtilObjectMapper.getObjectMapper().writeValueAsString(beanLog));
//				} catch (Exception ex) {
//					try {
//						logger.info(UtilObjectMapper.getObjectMapper().writeValueAsString(beanLog));
//					} catch (JsonProcessingException ex2) {
//						ex2.printStackTrace();
//					}
//				}
//			}
//		}).start();
//	}
//}
