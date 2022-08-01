package edu.hcmuaf.security;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

import edu.hcmuaf.dto.CartDTO;
import edu.hcmuaf.dto.NewDTO;
import edu.hcmuaf.dto.UserDTO;
import edu.hcmuaf.service.ICartService;
import edu.hcmuaf.service.IUserService;
import edu.hcmuaf.util.SecurityUtils;

@Component
public class CustomSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
	@Autowired
	private IUserService userService;
	@Autowired 
	private ICartService cartService;
	
	public static Integer count;
	
	public static Integer getCount() {
		return count;
	}

	public boolean isLogin = false;
	
	public boolean isLogin() {
		return isLogin;
	}

	public void setLogin(boolean isLogin) {
		this.isLogin = isLogin;
	}

	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
			throws IOException {
		String targetUrl = determineTargetUrl(authentication);
		if (response.isCommitted()) {
			return;
		}
		redirectStrategy.sendRedirect(request, response, targetUrl);
	}

	public RedirectStrategy getRedirectStrategy() {
		return redirectStrategy;
	}
	
	public void setRedirectStrategy(RedirectStrategy redirectStrategy) {
		this.redirectStrategy = redirectStrategy;
	}
	
	private String determineTargetUrl(Authentication authentication) {
		String url = "";
		List<String> roles = SecurityUtils.getAuthorities();
		if(roles.size() != 0) {
			if (isAdmin(roles)) {
				url = "/quan-tri/trang-chu";
				isLogin = true;
			} else if (isUser(roles)) {
				url = "/trang-chu";
				isLogin = true;
			}else {
				url = "/trang-chu";
				isLogin = true;
			}
		}
		return url;
	}
	
	public ModelAndView loadCart(String url) {
		ModelAndView mav = new ModelAndView(url);
			UserDTO userDTO = userService.findByUsername(SecurityUtils.getPrincipal().getUsername());
			CartDTO cartDTO = cartService.findById(userDTO.getCartId());
			mav.addObject("cart", cartDTO);
			mav.addObject("user", userDTO);
			count = cartDTO.getListNews().size();
		return mav;
	}

	private boolean isAdmin(List<String> roles) {
		if (roles.contains("ADMIN")) {
			return true;
		}
		return false;
	}
	
	private boolean isUser(List<String> roles) {
		if (roles.contains("USER")) {
			return true;
		}
		return false;
	}
	

}
