package com.example.springjpaweb5.config;
import org.springframework.web.filter.GenericFilterBean;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.MalformedParameterizedTypeException;

public class JwtFilter extends GenericFilterBean
{
    @Override
    public void doFilter( ServletRequest request, ServletResponse response, FilterChain filterChain )
        throws IOException, ServletException
    {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        String authHeader = httpServletRequest.getHeader( "authorization" );

        if ( "OPTIONS".equals( ( httpServletRequest.getMethod() ) ) )
        {
            httpServletResponse.setStatus( HttpServletResponse.SC_OK );
        }
        else
        {
            if ( authHeader == null || !authHeader.startsWith( "Bearer " ) )
            {
                throw new ServletException( "Invalid Token!" );
            }

            String token = authHeader.substring( 7 );

            try
            {
                Claims claims = Jwts.parser().setSigningKey( "this-secret-is-not-very-secret-99" ).parseClaimsJws(
                    token ).getBody();
                request.setAttribute( "claims", claims );
            }
            catch ( SignatureException | MalformedParameterizedTypeException e )
            {
                throw new ServletException( "Invalid Token!" );
            }
        }
        filterChain.doFilter( request, response );
    }
}