/**
 * 
 */
package net.webset.valid.sms;

/**
 * @author 梁雪峰
 *
 */
public class DefaultSmsCodeSender implements SmsCodeSender {

	@Override
	public void send(String mobile, String code) {
		System.out.println("向手机"+mobile+"发送短信验证码"+code);
	}

}
