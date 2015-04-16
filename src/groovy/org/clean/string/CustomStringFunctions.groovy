package org.clean.string

import java.text.Normalizer

/**
 * Created by wasim on 15/4/15.
 */
class CustomStringFunctions {

    static void inject() {
        String.metaClass.trunc = { len ->
            if (len < delegate.length()) {
                delegate[0..len - 1]
            } else {
                delegate
            }
        }

        String.metaClass.ellipsis = { len ->
            if (len < delegate.length()) {
                delegate[0..len - (ELLIPSIS.size() + 1)] + ELLIPSIS
            } else {
                delegate
            }
        }

        String.metaClass.clean = {
            FixChar.removeSpecialCharacter(delegate)
        }
    }

}
