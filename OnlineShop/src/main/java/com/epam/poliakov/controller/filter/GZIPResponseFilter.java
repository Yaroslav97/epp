package com.epam.poliakov.controller.filter;

import com.epam.poliakov.util.compressed_resp.GZIPResponseWrapper;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter("/*")
public class GZIPResponseFilter implements Filter {

    private static final String ACCEPT_ENCODING = "accept-encoding";
    private static final String GZIP = "gzip";

    public void init(FilterConfig filterConfig) {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;

        String acceptEncoding = req.getHeader(ACCEPT_ENCODING);
        if (acceptEncoding != null) {
            if (acceptEncoding.indexOf(GZIP) >= 0) {
                GZIPResponseWrapper gzipResponse = new GZIPResponseWrapper(resp);
                chain.doFilter(request, gzipResponse);
                gzipResponse.finish();
            }
        }
        chain.doFilter(request, response);
    }

    public void destroy() {

    }
}
