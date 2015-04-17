package org.clean.string

import groovy.transform.CompileStatic

import java.text.Normalizer

/**
 * @author wasim
 */
@CompileStatic
class FixChar {
    static boolean XMLQuoteMode = false
    static boolean CSVEscapeMode = false
    static boolean SQLEscapeMode = false
    static long charCount = 0
    static List<Character> extraChar = []

    static String removeSpecialCharacter(String text) {
        text.toCharArray().each { handleChar((int) it) }
        char[] text_char = extraChar as char[]
        return Normalizer.normalize(String.valueOf(text_char), Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "")
    }

    static void handleChar(int d) {
        charCount++
        switch (d) {
            case 127:  setChar(' '); break
            case 129:  setChar(' '); break
            case 141:  setChar(' '); break
            case 143:  setChar(' '); break
            case 144:  setChar(' '); break
            case 157:  setChar(' '); break /*absorb, no char in place */
            case 8364: setChar(' '); break
            case 128:  setChar('E'); break
            case 8218 :setChar(' '); break
            case 130:
                if (CSVEscapeMode) setChar('\\')
                else setChar(','); break
            case 402:  setChar(' '); break
            case 131:  setChar('f'); break
            case 8222: setChar(' '); break
            case 8220: setChar('"'); break
            case 8221: setChar('"'); break
            case 132:  setChar(' '); break
            case 147:  setChar(' '); break
            case 148:  setChar(' '); break
            case 187:  setChar(' '); break
            case 171:
                if (XMLQuoteMode) {
                    setChar('&'); setChar('q'); setChar('u'); setChar('o'); setChar('t'); setChar(';')
                } /* esc for double quote char */
                else setChar('"')
                break
            case 8230: setChar(' '); break
            case 133:  setChar('.'); setChar('.'); setChar('.'); break
            case 8224: setChar(' '); break
            case 134:  setChar('('); setChar('t'); setChar(')'); break /* dagger */
            case 8225: setChar(' '); break
            case 135:  setChar('('); setChar('t'); setChar('t'); setChar(')'); break /* double dagger */
            case 710:  setChar(' '); break
            case 136:  setChar('^'); break
            case 8240: setChar(' '); break
            case 84:   setChar('T'); break
            case 293:  setChar('h'); break
            case 239:  setChar('i'); break
            case 349:  setChar('s'); break
            case 32:   setChar(' '); break
            case 297:  setChar('i'); break
            case 353:  setChar('s'); break
            case 102:  setChar('f'); break
            case 367:  setChar('u'); break
            case 328:  setChar('n'); break
            case 311:  setChar('k'); break
            case 375:  setChar('y'); break

            case 352:  setChar('S'); break
            case 357:  setChar('t'); break
            case 341:  setChar('r'); break
            case 301:  setChar('i'); break
            case 324:  setChar('n'); break
            case 289:  setChar('g'); break
            case 137:  setChar('%'); break
            case 138:  setChar('S'); break
            case 8249: setChar(' '); break
            case 139:  setChar('<'); break
            case 338:  setChar(' '); break
            case 140:  setChar('O'); setChar('E'); break
            case 381:  setChar(' '); break
            case 142:  setChar('Z'); break
            case 8216: setChar(' '); break
            case 8217: setChar(' '); break
            case 145:  setChar(' '); break
            case 146:  setChar(' '); break
            case 180:
                setChar('\'')
                if (SQLEscapeMode) setChar('\'') /* esc for single quote char */
                break
            case 8226: setChar(' '); break
            case 8211: setChar(' '); break
            case 8212: setChar(' '); break
            case 149:  setChar(' '); break
            case 150:  setChar(' '); break
            case 151:  setChar(' '); break
            case 166:  setChar(' '); break
            case 173:  setChar('-'); break
            case 732:  setChar(' '); break
            case 152:  setChar('~'); break
            case 8482: setChar(' '); break
            case 153:  setChar('('); setChar('T'); setChar('M'); setChar(')'); break
            case 154:  setChar('s'); break
            case 8250: setChar(' '); break
            case 155:  setChar('>'); break
            case 339:  setChar(' '); break
            case 156:  setChar('o'); setChar('e'); break
            case 382:  setChar(' '); break
            case 158:  setChar('z'); break
            case 376:  setChar(' '); break
            case 159:  setChar('Y'); break
            case 160:  setChar(' '); break
            case 9632: setChar(' '); break
            case 182:  setChar(' '); break
            case 161:  setChar(" "); break
            case 172:  setChar('!'); break
            case 162:  setChar('c'); break
            case 163:  setChar('L'); break
            case 164:  setChar('$'); break
            case 165:  setChar('Y'); break
            case 167:  setChar('S'); break
            case 168:  setChar('.'); setChar('.'); break
            case 169:  setChar('('); setChar('c'); setChar(')'); break
            case 170:  setChar('a'); break
            case 174:  setChar('('); setChar('R'); setChar(')'); break
            case 175:  setChar(" "); break
            case 184:  setChar('_'); break
            case 176:  setChar(' '); break
            case 186:  setChar('o'); break
            case 177:  setChar('+'); setChar('-'); break
            case 178:  setChar('2'); break
            case 179:  setChar('3'); break
            case 181:  setChar('u'); break
            case 183:  setChar('.'); break
            case 185:  setChar('1'); break
            case 188:  setChar('1'); setChar('/'); setChar('4'); break
            case 189:  setChar('1'); setChar('/'); setChar('2'); break
            case 190:  setChar('3'); setChar('/'); setChar('4'); break
            case 191:  setChar('?'); break
            case 192:  setChar('A'); break
            case 193:  setChar('A'); break
            case 194:  setChar('A'); break
            case 195:  setChar('A'); break
            case 196:  setChar('A'); break
            case 197:  setChar('A'); break
            case 198:  setChar('A'); setChar('E'); break
            case 199:  setChar('C'); break
            case 200:  setChar('E'); break
            case 201:  setChar('E'); break
            case 202:  setChar('E'); break
            case 203:  setChar('E'); break
            case 204:  setChar('I'); break
            case 205:  setChar('I'); break
            case 206:  setChar('I'); break
            case 207:  setChar('I'); break
            case 208:  setChar('D'); break
            case 209:  setChar('N'); break
            case 210:  setChar('O'); break
            case 211:  setChar('O'); break
            case 212:  setChar('O'); break
            case 213:  setChar('O'); break
            case 214:  setChar('O'); break
            case 215:  setChar('x'); break
            case 216:  setChar('O'); break
            case 217:  setChar('U'); break
            case 218:  setChar('U'); break
            case 219:  setChar('U'); break
            case 220:  setChar('U'); break
            case 221:  setChar('Y'); break
            case 222:  setChar('P'); break
            case 223:  setChar('s'); setChar('s'); break
            case 224:  setChar('a'); break
            case 225:  setChar('a'); break
            case 226:  setChar('a'); break
            case 227:  setChar('a'); break
            case 228:  setChar('a'); break
            case 229:  setChar('a'); break
            case 230:  setChar('a'); setChar('e'); break
            case 231:  setChar('c'); break
            case 232:  setChar('e'); break
            case 233:  setChar('e'); break
            case 234:  setChar('e'); break
            case 235:  setChar('e'); break
            case 236:  setChar('i'); break
            case 237:  setChar('i'); break
            case 238:  setChar('i'); break
            case 240:  setChar('d'); break
            case 241:  setChar('n'); break
            case 242:  setChar('o'); break
            case 243:  setChar('o'); break
            case 244:  setChar('o'); break
            case 245:  setChar('o'); break
            case 246:  setChar('o'); break
            case 247:  setChar('/'); break
            case 248:  setChar('o'); break
            case 249:  setChar('u'); break
            case 250:  setChar('u'); break
            case 251:  setChar('u'); break
            case 252:  setChar('u'); break
            case 253:  setChar('y'); break
            case 254:  setChar('b'); break
            case 255:  setChar('y'); break
        /* some addl cases for msft utf8s, mostly latin */
            case 915:  setChar('T'); break
            case 920:  setChar('O'); break
            case 931:  setChar('E'); break
            case 945:  setChar('a'); break
            case 949:  setChar('e'); break
            case 963:  setChar('s'); break
            case 964:  setChar('t'); break
            case 934:  setChar('p'); break
            case 960:  setChar('p'); setChar('i'); break
            case 966:  setChar('P'); break
            case 8734: setChar('o'); setChar('o'); break
            case 8359: setChar('P'); setChar('t'); setChar('s'); break
            case 9617: setChar(' '); break
            case 9618: setChar(' '); break
            case 9619: setChar(' '); break
            case 9532: setChar('+'); break
            case 9574: setChar('T'); break
            case 9553: setChar('|'); setChar('|'); break
            case 8992: setChar(' '); break
            case 8993: setChar(' '); break
            case 9508: setChar(' '); break
            case 9474: setChar('|'); break
            case 9516: setChar('t'); break
            case 8745: setChar('='); break
            case 8801: setChar('+'); setChar('-'); break
            case 8805: setChar('>'); setChar('='); break
            case 8804: setChar('<'); setChar('='); break
            case 8776: setChar('~'); break
            case 8729: setChar('.'); break
            case 8730: setChar('V'); break
            case 8319: setChar('n'); break
            case 9566: setChar(' '); break
            case 9571: setChar(' '); break
            case 9564: setChar(' '); break
            case 9563: setChar(' '); break
            case 9557: setChar(' '); break
            case 8976: setChar(' '); break
            case 9569: setChar(' '); break
            case 9570: setChar(' '); break
            case 9558: setChar(' '); break
            case 9559: setChar(' '); break
            case 9565: setChar(' '); break

            case 0:    setChar(' '); break
            case 1:    setChar(' '); break
            case 2:    setChar(' '); break
            case 3:    setChar(' '); break
            case 4:    setChar(' '); break
            case 5:    setChar(' '); break
            case 6:    setChar(' '); break
            case 7:    setChar(' '); break
            case 8:    setChar(' '); break
            case 11:   setChar(' '); break
            case 12:   setChar(' '); break
            case 14:   setChar(' '); break
            case 15:   setChar(' '); break
            case 16:   setChar(' '); break
            case 17:   setChar(' '); break
            case 18:   setChar(' '); break
            case 19:   setChar(' '); break
            case 20:   setChar(' '); break
            case 21:   setChar(' '); break
            case 22:   setChar(' '); break
            case 23:   setChar(' '); break
            case 24:   setChar(' '); break
            case 25:   setChar(' '); break
            case 26:   setChar(' '); break
            case 27:   setChar(' '); break
            case 28:   setChar(' '); break
            case 29:   setChar(' '); break
            case 31:   setChar(' '); break
            case 30:   break
            default:
                setChar(Character.toString((char) d))
        }
    }

    static void setChar(String ch) {
        extraChar << (ch as Character)
    }
}
