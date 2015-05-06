package org.clean.string

import java.text.Normalizer

/**
 * @author wasim
 */

class FixChar {

    static String removeSpecialCharacter(String text) {
        List<Character> extraChar = []
        text.toCharArray().each { extraChar += handleChar((int) it) }
        char[] text_char = extraChar as char[]
        return Normalizer.normalize(String.valueOf(text_char).trim(), Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "")
    }

    static List<Character> handleChar(int d) {
        List<Character> extraChar = []
        switch (d) {
            case 127:  extraChar << ' '; break
            case 129:  extraChar << ' '; break
            case 141:  extraChar << ' '; break
            case 143:  extraChar << ' '; break
            case 144:  extraChar << ' '; break
            case 157:  extraChar << ' '; break /*absorb, no char in place */
            case 8364: extraChar << ' '; break
            case 128:  extraChar << 'E'; break
            case 8218 :extraChar << ' '; break
            case 130:  extraChar << ','; break
            case 402:  extraChar << ' '; break
            case 131:  extraChar << 'f'; break
            case 8222: extraChar << ' '; break
            case 8220: extraChar << '"'; break
            case 8221: extraChar << '"'; break
            case 132:  extraChar << ' '; break
            case 147:  extraChar << ' '; break
            case 148:  extraChar << ' '; break
            case 187:  extraChar << ' '; break
            case 171:  extraChar << '"'; break
            case 8230: extraChar << ' '; break
            case 133:  extraChar << '.'; extraChar << '.'; extraChar << '.'; break
            case 8224: extraChar << ' '; break
            case 134:  extraChar << '('; extraChar << 't'; extraChar << ''; break /* dagger */
            case 8225: extraChar << ' '; break
            case 135:  extraChar << '('; extraChar << 't'; extraChar << 't'; extraChar << ''; break /* double dagger */
            case 710:  extraChar << ' '; break
            case 136:  extraChar << '^'; break
            case 8240: extraChar << ' '; break
            case 239:  extraChar << 'i'; break
            case 297:  extraChar << 'i'; break
            case 353:  extraChar << 's'; break
            case 102:  extraChar << 'f'; break
            case 367:  extraChar << 'u'; break
            case 328:  extraChar << 'n'; break
            case 311:  extraChar << 'k'; break
            case 375:  extraChar << 'y'; break

            case 352:  extraChar << 'S'; break
            case 357:  extraChar << 't'; break
            case 341:  extraChar << 'r'; break
            case 301:  extraChar << 'i'; break
            case 324:  extraChar << 'n'; break
            case 289:  extraChar << 'g'; break
            case 137:  extraChar << '%'; break
            case 138:  extraChar << 'S'; break
            case 8249: extraChar << ' '; break
            case 139:  extraChar << '<'; break
            case 338:  extraChar << ' '; break
            case 140:  extraChar << 'O'; extraChar << 'E'; break
            case 381:  extraChar << ' '; break
            case 142:  extraChar << 'Z'; break
            case 8216: extraChar << ' '; break
            case 8217: extraChar << ' '; break
            case 145:  extraChar << ' '; break
            case 146:  extraChar << ' '; break
            case 180:  extraChar << '\'';break
            case 8226: extraChar << ' '; break
            case 8211: extraChar << ' '; break
            case 8212: extraChar << ' '; break
            case 149:  extraChar << ' '; break
            case 150:  extraChar << ' '; break
            case 151:  extraChar << ' '; break
            case 166:  extraChar << ' '; break
            case 173:  extraChar << '-'; break
            case 732:  extraChar << ' '; break
            case 152:  extraChar << '~'; break
            case 8482: extraChar << ' '; break
            case 153:  extraChar << '('; extraChar << 'T'; extraChar << 'M'; extraChar << ''; break
            case 154:  extraChar << 's'; break
            case 8250: extraChar << ' '; break
            case 155:  extraChar << '>'; break
            case 339:  extraChar << ' '; break
            case 156:  extraChar << 'o'; extraChar << 'e'; break
            case 382:  extraChar << ' '; break
            case 158:  extraChar << 'z'; break
            case 376:  extraChar << ' '; break
            case 159:  extraChar << 'Y'; break
            case 160:  extraChar << ' '; break
            case 9632: extraChar << ' '; break
            case 182:  extraChar << ' '; break
            case 161:  extraChar << " "; break
            case 172:  extraChar << '!'; break
            case 162:  extraChar << 'c'; break
            case 163:  extraChar << 'L'; break
            case 164:  extraChar << '$'; break
            case 165:  extraChar << 'Y'; break
            case 167:  extraChar << 'S'; break
            case 168:  extraChar << '.'; extraChar << '.'; break
            case 169:  extraChar << '('; extraChar << 'c'; extraChar << ''; break
            case 170:  extraChar << 'a'; break
            case 174:  extraChar << '('; extraChar << 'R'; extraChar << ''; break
            case 175:  extraChar << " "; break
            case 184:  extraChar << '_'; break
            case 176:  extraChar << ' '; break
            case 186:  extraChar << 'o'; break
            case 177:  extraChar << '+'; extraChar << '-'; break
            case 178:  extraChar << '2'; break
            case 179:  extraChar << '3'; break
            case 181:  extraChar << 'u'; break
            case 183:  extraChar << '.'; break
            case 185:  extraChar << '1'; break
            case 188:  extraChar << '1'; extraChar << '/'; extraChar << '4'; break
            case 189:  extraChar << '1'; extraChar << '/'; extraChar << '2'; break
            case 190:  extraChar << '3'; extraChar << '/'; extraChar << '4'; break
            case 191:  extraChar << '?'; break
            case 192:  extraChar << 'A'; break
            case 193:  extraChar << 'A'; break
            case 194:  extraChar << 'A'; break
            case 195:  extraChar << 'A'; break
            case 196:  extraChar << 'A'; break
            case 197:  extraChar << 'A'; break
            case 198:  extraChar << 'A'; extraChar << 'E'; break
            case 199:  extraChar << 'C'; break
            case 200:  extraChar << 'E'; break
            case 201:  extraChar << 'E'; break
            case 202:  extraChar << 'E'; break
            case 203:  extraChar << 'E'; break
            case 204:  extraChar << 'I'; break
            case 205:  extraChar << 'I'; break
            case 206:  extraChar << 'I'; break
            case 207:  extraChar << 'I'; break
            case 208:  extraChar << 'D'; break
            case 209:  extraChar << 'N'; break
            case 210:  extraChar << 'O'; break
            case 211:  extraChar << 'O'; break
            case 212:  extraChar << 'O'; break
            case 213:  extraChar << 'O'; break
            case 214:  extraChar << 'O'; break
            case 215:  extraChar << 'x'; break
            case 216:  extraChar << 'O'; break
            case 217:  extraChar << 'U'; break
            case 218:  extraChar << 'U'; break
            case 219:  extraChar << 'U'; break
            case 220:  extraChar << 'U'; break
            case 221:  extraChar << 'Y'; break
            case 222:  extraChar << 'P'; break
            case 223:  extraChar << 's'; extraChar << 's'; break
            case 224:  extraChar << 'a'; break
            case 225:  extraChar << 'a'; break
            case 226:  extraChar << 'a'; break
            case 227:  extraChar << 'a'; break
            case 228:  extraChar << 'a'; break
            case 229:  extraChar << 'a'; break
            case 230:  extraChar << 'a'; extraChar << 'e'; break
            case 231:  extraChar << 'c'; break
            case 232:  extraChar << 'e'; break
            case 233:  extraChar << 'e'; break
            case 234:  extraChar << 'e'; break
            case 235:  extraChar << 'e'; break
            case 236:  extraChar << 'i'; break
            case 237:  extraChar << 'i'; break
            case 238:  extraChar << 'i'; break
            case 240:  extraChar << 'd'; break
            case 241:  extraChar << 'n'; break
            case 242:  extraChar << 'o'; break
            case 243:  extraChar << 'o'; break
            case 244:  extraChar << 'o'; break
            case 245:  extraChar << 'o'; break
            case 246:  extraChar << 'o'; break
            case 247:  extraChar << '/'; break
            case 248:  extraChar << 'o'; break
            case 249:  extraChar << 'u'; break
            case 250:  extraChar << 'u'; break
            case 251:  extraChar << 'u'; break
            case 252:  extraChar << 'u'; break
            case 253:  extraChar << 'y'; break
            case 254:  extraChar << 'b'; break
            case 255:  extraChar << 'y'; break
        /* some addl cases for msft utf8s, mostly latin */
            case 915:  extraChar << 'T'; break
            case 920:  extraChar << 'O'; break
            case 931:  extraChar << 'E'; break
            case 945:  extraChar << 'a'; break
            case 949:  extraChar << 'e'; break
            case 963:  extraChar << 's'; break
            case 964:  extraChar << 't'; break
            case 934:  extraChar << 'p'; break
            case 960:  extraChar << 'p'; extraChar << 'i'; break
            case 966:  extraChar << 'P'; break
            case 8734: extraChar << 'o'; extraChar << 'o'; break
            case 8359: extraChar << 'P'; extraChar << 't'; extraChar << 's'; break
            case 9617: extraChar << ' '; break
            case 9618: extraChar << ' '; break
            case 9619: extraChar << ' '; break
            case 9532: extraChar << '+'; break
            case 9574: extraChar << 'T'; break
            case 9553: extraChar << '|'; extraChar << '|'; break
            case 8992: extraChar << ' '; break
            case 8993: extraChar << ' '; break
            case 9508: extraChar << ' '; break
            case 9474: extraChar << '|'; break
            case 9516: extraChar << 't'; break
            case 8745: extraChar << '='; break
            case 8801: extraChar << '+'; extraChar << '-'; break
            case 8805: extraChar << '>'; extraChar << '='; break
            case 8804: extraChar << '<'; extraChar << '='; break
            case 8776: extraChar << '~'; break
            case 8729: extraChar << '.'; break
            case 8730: extraChar << 'V'; break
            case 8319: extraChar << 'n'; break
            case 9566: extraChar << ' '; break
            case 9571: extraChar << ' '; break
            case 9564: extraChar << ' '; break
            case 9563: extraChar << ' '; break
            case 9557: extraChar << ' '; break
            case 8976: extraChar << ' '; break
            case 9569: extraChar << ' '; break
            case 9570: extraChar << ' '; break
            case 9558: extraChar << ' '; break
            case 9559: extraChar << ' '; break
            case 9565: extraChar << ' '; break

            case 0:    extraChar << ' '; break
            case 1:    extraChar << ' '; break
            case 2:    extraChar << ' '; break
            case 3:    extraChar << ' '; break
            case 4:    extraChar << ' '; break
            case 5:    extraChar << ' '; break
            case 6:    extraChar << ' '; break
            case 7:    extraChar << ' '; break
            case 8:    extraChar << ' '; break
            case 11:   extraChar << ' '; break
            case 12:   extraChar << ' '; break
            case 14:   extraChar << ' '; break
            case 15:   extraChar << ' '; break
            case 16:   extraChar << ' '; break
            case 17:   extraChar << ' '; break
            case 18:   extraChar << ' '; break
            case 19:   extraChar << ' '; break
            case 20:   extraChar << ' '; break
            case 21:   extraChar << ' '; break
            case 22:   extraChar << ' '; break
            case 23:   extraChar << ' '; break
            case 24:   extraChar << ' '; break
            case 25:   extraChar << ' '; break
            case 26:   extraChar << ' '; break
            case 27:   extraChar << ' '; break
            case 28:   extraChar << ' '; break
            case 29:   extraChar << ' '; break
            case 31:   extraChar << ' '; break
            case 30:   break
            default:
                extraChar << Character.toString((char) d)
        }
        return extraChar.collect { it as Character}
    }
}
