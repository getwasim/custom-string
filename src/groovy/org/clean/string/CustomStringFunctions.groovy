package org.clean.string

/**
 * @author wasim
 */
class CustomStringFunctions {

    static void inject() {
        String.metaClass.trunc = { int len ->
            if (len < delegate.length()) {
                delegate[0..len - 1]
            } else {
                delegate
            }
        }

        String.metaClass.ellipsis = { int len ->
            if (len < delegate.length()) {
                delegate[0..len - (ELLIPSIS.size() + 1)] + ELLIPSIS
            } else {
                delegate
            }
        }

        String.metaClass.clean = { ->
            FixChar.removeSpecialCharacter(delegate)
        }
    }
}
