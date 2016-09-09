package SpotiKeys;
import java.util.HashMap;

public class macKeyConversion {
	public static final HashMap<Integer, Integer> map = new HashMap<Integer, Integer>(){
		{
			put(new Integer(27), 0x0001); // Escape
			put(new Integer(192), 0x0029); // Backquote
			put(new Integer(49), 0x0002); // 1
			put(new Integer(50), 0x0003); // 2
			put(new Integer(51), 0x0004); // 3
			put(new Integer(52), 0x0005); // 4
			put(new Integer(53), 0x0006); // 5
			put(new Integer(54), 0x0007); // 6
			put(new Integer(55), 0x0008); // 7
			put(new Integer(56), 0x0009); // 8
			put(new Integer(57), 0x000A); // 9
			put(new Integer(48), 0x000B); // 0
			put(new Integer(45), 0x000C); // -
			put(new Integer(61), 0x000D); // =
			put(new Integer(8), 0x000E); // delete/backspace
			put(new Integer(81), 0x0010); // q
			put(new Integer(87), 0x0011); // w
			put(new Integer(69), 0x0012); // e
			put(new Integer(82), 0x0013); // r
			put(new Integer(84), 0x0014); // t
			put(new Integer(89), 0x0015); // y
			put(new Integer(85), 0x0016); // u
			put(new Integer(73), 0x0017); // i
			put(new Integer(79), 0x0018); // o
			put(new Integer(80), 0x0019); // p
			put(new Integer(91), 0x001A); // [
			put(new Integer(93), 0x001B); // ]
			put(new Integer(92), 0x002B); // \
			put(new Integer(20), 0x003A); // caps lock
			put(new Integer(65), 0x001E); // a
			put(new Integer(83), 0x001F); // s
			put(new Integer(68), 0x0020); // d
			put(new Integer(70), 0x0021); // f
			put(new Integer(71), 0x0022); // g
			put(new Integer(72), 0x0023); // h
			put(new Integer(74), 0x0024); // j
			put(new Integer(75), 0x0025); // k
			put(new Integer(76), 0x0026); // l
			put(new Integer(59), 0x0027); // ;
			put(new Integer(222), 0x0028); // '
			put(new Integer(10), 0x001C); // enter
			put(new Integer(16), 0x002A); // shift
			put(new Integer(90), 0x002C); // z
			put(new Integer(88), 0x002D); // x
			put(new Integer(67), 0x002E); // c
			put(new Integer(86), 0x002F); // v
			put(new Integer(66), 0x0030); // b
			put(new Integer(78), 0x0031); // n
			put(new Integer(77), 0x0032); // m
			put(new Integer(44), 0x0033); // ,
			put(new Integer(46), 0x0034); // .
			put(new Integer(47), 0x0035); // /
			put(new Integer(17), 0x001D); // control
			put(new Integer(18), 0x0038); // option/alt
			put(new Integer(157), 0x0E5B); // command
			put(new Integer(32), 0x0039); // space
			put(new Integer(37), 0xE04B); // left
			put(new Integer(39), 0xE04D); // right
			put(new Integer(38), 0xE048); // up
			put(new Integer(40), 0xE050); // down
		}
	};
	public static final HashMap<Integer, String> strMap = new HashMap<Integer, String>(){
		{
			put(new Integer(0x0001), "Escape"); // Escape
			put(new Integer(0x0029), "Backquote"); // Backquote
			put(new Integer(0x0002), "1"); // 1
			put(new Integer(0x0003), "2"); // 2
			put(new Integer(0x0004), "3"); // 3
			put(new Integer(0x0005), "4"); // 4
			put(new Integer(0x0006), "5"); // 5
			put(new Integer(0x0007), "6"); // 6
			put(new Integer(0x0008), "7"); // 7
			put(new Integer(0x0009), "8"); // 8
			put(new Integer(0x000A), "9"); // 9
			put(new Integer(0x000B), "0"); // 0
			put(new Integer(0x000C), "-"); // -
			put(new Integer(0x000D), "="); // =
			put(new Integer(0x000E), "delete"); // delete
			put(new Integer(0x0010), "q"); // q
			put(new Integer(0x0011), "w"); // w
			put(new Integer(0x0012), "e"); // e
			put(new Integer(0x0013), "r"); // r
			put(new Integer(0x0014), "t"); // t
			put(new Integer(0x0015), "y"); // y
			put(new Integer(0x0016), "u"); // u
			put(new Integer(0x0017), "i"); // i
			put(new Integer(0x0018), "o"); // o
			put(new Integer(0x0019), "p"); // p
			put(new Integer(0x001A), "["); // [
			put(new Integer(0x001B), "]"); // ]
			put(new Integer(0x002B), "backslash"); // \
			put(new Integer(0x003A), "caps lock"); // caps lock
			put(new Integer(0x001E), "a"); // a
			put(new Integer(0x001F), "s"); // s
			put(new Integer(0x0020), "d"); // d
			put(new Integer(0x0021), "f"); // f
			put(new Integer(0x0022), "g"); // g
			put(new Integer(0x0023), "h"); // h
			put(new Integer(0x0024), "j"); // j
			put(new Integer(0x0025), "k"); // k
			put(new Integer(0x0026), "l"); // l
			put(new Integer(0x0027), ";"); // ;
			put(new Integer(0x0028), "'"); // '
			put(new Integer(0x001C), "enter"); // enter
			put(new Integer(0x002A), "shift"); // shift
			put(new Integer(0x002C), "z"); // z
			put(new Integer(0x002D), "x"); // x
			put(new Integer(0x002E), "c"); // c
			put(new Integer(0x002F), "v"); // v
			put(new Integer(0x0030), "b"); // b
			put(new Integer(0x0031), "n"); // n
			put(new Integer(0x0032), "m"); // m
			put(new Integer(0x0033), ","); // ,
			put(new Integer(0x0034), "."); // .
			put(new Integer(0x0035), "/"); // /
			put(new Integer(0x001D), "control"); // control
			put(new Integer(0x0038), "option/alt"); // option/alt
			put(new Integer(0x0E5B), "command"); // command
			put(new Integer(0x0039), "space"); // space
			put(new Integer(0xE04B), "left"); // left
			put(new Integer(0xE04D), "right"); // right
			put(new Integer(0xE048), "up"); // up
			put(new Integer(0xE050), "down"); // down
		}
	};
}
