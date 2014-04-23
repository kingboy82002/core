package cn.com.free.action;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.com.free.base.BaseAction;
import cn.com.free.util.ActionResult;

public class UserAction extends BaseAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Logger logger = LoggerFactory.getLogger(UserAction.class);
	
	
	@Override
	public String execute() throws Exception {
		if(getMethod().equals("reg")){
			return this.reg();
		}else if(getMethod().equals("login")){
			return this.login();
		}else if(getMethod().equals("checkpwd")){
			this.checkpwd();
		}
		return null;
	}

	public String login(){
		try {
			String username = getParameter("username");
			logger.info("运行结果：{}","成功了");
			addActionMessage("登录成功");
			return ActionResult.SUCCESS;
		} catch (Exception e) {
			logger.error("运行结果：{},错误信息：{}","失败了",e.getMessage());
			addActionError(e.getMessage());
			return ActionResult.Global_ERROR;
		}
	}
	
	public String reg(){
		try {
			logger.info("运行结果：{}","成功了");
			addActionMessage("注册成功");
			return ActionResult.SUCCESS;
		} catch (Exception e) {
			logger.error("运行结果：{},错误信息：{}","失败了",e.getMessage());
			addActionError(e.getMessage());
			return ActionResult.Global_ERROR;
		}
	}
	
    public void checkpwd(){
    	outputResponse("hello world!杭州");
    }
}
