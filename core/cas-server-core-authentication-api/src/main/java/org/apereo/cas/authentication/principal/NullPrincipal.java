package org.apereo.cas.authentication.principal;

import org.apereo.cas.authentication.Authentication;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

/**
 * Null principal implementation that allows us to construct {@link Authentication}s in the event that no
 * principal is resolved during the authentication process.
 *
 * @author Marvin S. Addison
 * @author Misagh Moayyed
 * @since 4.1.0
 */
@Slf4j
@Getter
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class NullPrincipal implements Principal {

    private static final long serialVersionUID = 2309300426720915104L;

    /**
     * The nobody principal.
     */
    private static final String NOBODY = "nobody";

    /**
     * The singleton instance.
     **/
    private static NullPrincipal INSTANCE;

    private Map<String, Object> attributes;

    /**
     * Returns the single instance of this class. Will create
     * one if none exists.
     *
     * @return the instance
     */
    public static NullPrincipal getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new NullPrincipal();
        }
        return INSTANCE;
    }

    @JsonIgnore
    @Override
    public String getId() {
        return NOBODY;
    }
}
