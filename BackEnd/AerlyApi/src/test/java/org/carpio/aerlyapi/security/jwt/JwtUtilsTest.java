package org.carpio.aerlyapi.security.jwt;

import io.jsonwebtoken.Claims;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.test.util.ReflectionTestUtils;

import java.security.Key;

import static org.junit.jupiter.api.Assertions.*;

class JwtUtilsTest {

    private JwtUtils jwtUtils;

    private static final String SECRET_KEY = "dGVzdFNlY3JldEtleUZvclRlc3RpbmdPbmx5UGxlYXNlRG9Ob3RVc2VJblByb2R1Y3Rpb24xMjM0NTY=";
    private static final String TIME_EXPIRATION = "86400000"; // 24 hours

    @BeforeEach
    void setUp() {
        jwtUtils = new JwtUtils();
        ReflectionTestUtils.setField(jwtUtils, "secretKey", SECRET_KEY);
        ReflectionTestUtils.setField(jwtUtils, "timeExpiration", TIME_EXPIRATION);
    }

    @Test
    @DisplayName("generateAccesToken should create valid JWT token")
    void generateAccesToken_CreatesValidToken() {
        String username = "test@example.com";

        String token = jwtUtils.generateAccesToken(username);

        assertNotNull(token);
        assertFalse(token.isEmpty());
        assertTrue(token.contains("."));
    }

    @Test
    @DisplayName("isTokenValid should return true for valid token")
    void isTokenValid_WhenValidToken_ReturnsTrue() {
        String username = "test@example.com";
        String token = jwtUtils.generateAccesToken(username);

        boolean result = jwtUtils.isTokenValid(token);

        assertTrue(result);
    }

    @Test
    @DisplayName("isTokenValid should return false for invalid token")
    void isTokenValid_WhenInvalidToken_ReturnsFalse() {
        String invalidToken = "invalid.token.here";

        boolean result = jwtUtils.isTokenValid(invalidToken);

        assertFalse(result);
    }

    @Test
    @DisplayName("isTokenValid should return false for malformed token")
    void isTokenValid_WhenMalformedToken_ReturnsFalse() {
        String malformedToken = "notavalidjwttoken";

        boolean result = jwtUtils.isTokenValid(malformedToken);

        assertFalse(result);
    }

    @Test
    @DisplayName("getUsernameFromToken should return correct username")
    void getUsernameFromToken_ReturnsCorrectUsername() {
        String username = "test@example.com";
        String token = jwtUtils.generateAccesToken(username);

        String result = jwtUtils.getUsernameFromToken(token);

        assertEquals(username, result);
    }

    @Test
    @DisplayName("extractAllClaims should return claims from valid token")
    void extractAllClaims_ReturnsClaimsFromValidToken() {
        String username = "test@example.com";
        String token = jwtUtils.generateAccesToken(username);

        Claims claims = jwtUtils.extractAllClaims(token);

        assertNotNull(claims);
        assertEquals(username, claims.getSubject());
        assertNotNull(claims.getIssuedAt());
        assertNotNull(claims.getExpiration());
    }

    @Test
    @DisplayName("getClaim should extract specific claim")
    void getClaim_ExtractsSpecificClaim() {
        String username = "test@example.com";
        String token = jwtUtils.generateAccesToken(username);

        String subject = jwtUtils.getClaim(token, Claims::getSubject);

        assertEquals(username, subject);
    }

    @Test
    @DisplayName("getSignaturekey should return valid Key")
    void getSignaturekey_ReturnsValidKey() {
        Key key = jwtUtils.getSignaturekey();

        assertNotNull(key);
        assertTrue(key.getAlgorithm().contains("HmacSHA"));
    }

    @Test
    @DisplayName("Generated token should have correct expiration time")
    void generatedToken_HasCorrectExpirationTime() {
        String username = "test@example.com";
        String token = jwtUtils.generateAccesToken(username);

        Claims claims = jwtUtils.extractAllClaims(token);

        long expectedExpiration = Long.parseLong(TIME_EXPIRATION);
        long actualExpiration = claims.getExpiration().getTime() - claims.getIssuedAt().getTime();

        assertTrue(actualExpiration <= expectedExpiration);
        assertTrue(actualExpiration > expectedExpiration - 1000);
    }

    @Test
    @DisplayName("Different usernames should produce different tokens")
    void differentUsernames_ProduceDifferentTokens() {
        String token1 = jwtUtils.generateAccesToken("user1@example.com");
        String token2 = jwtUtils.generateAccesToken("user2@example.com");

        assertNotEquals(token1, token2);
    }
}
