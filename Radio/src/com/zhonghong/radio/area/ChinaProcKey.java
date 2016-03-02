package com.zhonghong.radio.area;

import com.zhonghong.radio.utils.T;

/**
 * @author YC
 * @time 2016-2-26 ����10:32:59
 */
public class ChinaProcKey implements AreaProcKey {

	@Override
	public int ProcKey_0(int freq, boolean bFM) {
		int result = 0;
		if (bFM)
		{
			switch (freq) {
			case 10:
				result = T.KEYBOARD_EFFECTIVE_0_8;
				break;
			case 90:
			case 100:
				result = T.KEYBOARD_EFFECTIVE_ALL;
				break;
			case 1000:
			case 1010:
			case 1020:
			case 1030:
			case 1040:
			case 1050:
			case 1060:
			case 1070:
				result = T.KEYBOARD_EFFECTIVE_05;
				break;
			case 1080:
				result = T.KEYBOARD_EFFECTIVE_0;
				break;
			default:
				if (freq >= 880 && freq < 1000)
				{
					result = T.KEYBOARD_EFFECTIVE_05;
				}
				else if (freq >= 8750)
				{
					result = T.KEYBOARD_EFFECTIVE_NO;
				}
					break;
			}
//			result |= T.KEYBOARD_EFFECTIVE_OK;
		}
		else
		{
			switch (freq) {
			case 10:
				result = T.KEYBOARD_EFFECTIVE_ALL;
				break;
			case 60:
				result = T.KEYBOARD_EFFECTIVE_3;
				break;
			case 70:
				result = T.KEYBOARD_EFFECTIVE_2;
				break;
			case 80:
				result = T.KEYBOARD_EFFECTIVE_1;
				break;
			case 90:
				result = T.KEYBOARD_EFFECTIVE_09;
				break;
			case 100:
				result = T.KEYBOARD_EFFECTIVE_8;
				break;
			case 110:
				result = T.KEYBOARD_EFFECTIVE_7;
				break;
			case 120:
				result = T.KEYBOARD_EFFECTIVE_6;
				break;
			case 130:
				result = T.KEYBOARD_EFFECTIVE_5;
				break;
			case 140:
				result = T.KEYBOARD_EFFECTIVE_4;
				break;
			case 150:
				result = T.KEYBOARD_EFFECTIVE_3;
				break;
			case 160:
				result = T.KEYBOARD_EFFECTIVE_2;
				break;
			default:
				if (freq >= 540)
				{
					result = T.KEYBOARD_EFFECTIVE_NO;
				}
				break;
			}
		}
//		result |= T.KEYBOARD_EFFECTIVE_DEL;
//		result |= T.KEYBOARD_EFFECTIVE_CANCLE;
		return result;
	}

	@Override
	public int ProcKey_1(int freq, boolean bFM) {

		int result = 0;
		if (bFM)
		{
			switch (freq) {
			case 1:
				result = T.KEYBOARD_EFFECTIVE_0;
				break;
			case 91:
			case 101:
				result = T.KEYBOARD_EFFECTIVE_ALL;
				break;
			case 1001:
			case 1011:
			case 1021:
			case 1031:
			case 1041:
			case 1051:
			case 1061:
			case 1071:
				result = T.KEYBOARD_EFFECTIVE_05;
				break;
			default:
				if (freq > 880 && freq < 1000)
				{
					result = T.KEYBOARD_EFFECTIVE_05;
				}
				else if (freq >= 8750)
				{
					result = T.KEYBOARD_EFFECTIVE_NO;
				}
					break;
			}
//			result |= T.KEYBOARD_EFFECTIVE_OK;
		}
		else
		{
			switch (freq) {
			case 1:
				result = T.KEYBOARD_EFFECTIVE_0_6;
				break;
			case 11:
				result = T.KEYBOARD_EFFECTIVE_ALL;
				break;
			case 61:
				result = T.KEYBOARD_EFFECTIVE_2;
				break;
			case 71:
				result = T.KEYBOARD_EFFECTIVE_1;
				break;
			case 81:
				result = T.KEYBOARD_EFFECTIVE_09;
				break;
			case 91:
				result = T.KEYBOARD_EFFECTIVE_8;
				break;
			case 101:
				result = T.KEYBOARD_EFFECTIVE_7;
				break;
			case 111:
				result = T.KEYBOARD_EFFECTIVE_6;
				break;
			case 121:
				result = T.KEYBOARD_EFFECTIVE_5;
				break;
			case 131:
				result = T.KEYBOARD_EFFECTIVE_4;
				break;
			case 141:
				result = T.KEYBOARD_EFFECTIVE_3;
				break;
			case 151:
				result = T.KEYBOARD_EFFECTIVE_2;
				break;
			case 161:
				result = T.KEYBOARD_EFFECTIVE_1;
				break;
			default:
				if (freq >= 530)
				{
					result = T.KEYBOARD_EFFECTIVE_NO;
				}
				break;
			}
			
		}
//		result |= T.KEYBOARD_EFFECTIVE_DEL;
//		result |= T.KEYBOARD_EFFECTIVE_CANCLE;
		return result;
	}

	@Override
	public int ProcKey_2(int freq, boolean bFM) {
		int result = 0;
		if (bFM)
		{
			switch (freq) {
			case 92:
			case 102:
				result = T.KEYBOARD_EFFECTIVE_ALL;
				break;
			case 1002:
			case 1012:
			case 1022:
			case 1032:
			case 1042:
			case 1052:
			case 1062:
			case 1072:
				result = T.KEYBOARD_EFFECTIVE_05;
				break;
			default:
				if (freq > 880 && freq < 1000)
				{
					result = T.KEYBOARD_EFFECTIVE_05;
				}
				else if (freq >= 8750)
				{
					result = T.KEYBOARD_EFFECTIVE_NO;
				}
					break;
			}
//			result |= T.KEYBOARD_EFFECTIVE_OK;
		}
		else
		{
			switch (freq) {
			case 12:
				result = T.KEYBOARD_EFFECTIVE_ALL;
				break;
			case 52:
				result = T.KEYBOARD_EFFECTIVE_2;
				break;
			case 62:
				result = T.KEYBOARD_EFFECTIVE_1;
				break;
			case 72:
				result = T.KEYBOARD_EFFECTIVE_09;
				break;
			case 82:
				result = T.KEYBOARD_EFFECTIVE_8;
				break;
			case 92:
				result = T.KEYBOARD_EFFECTIVE_7;
				break;
			case 102:
				result = T.KEYBOARD_EFFECTIVE_6;
				break;
			case 112:
				result = T.KEYBOARD_EFFECTIVE_5;
				break;
			case 122:
				result = T.KEYBOARD_EFFECTIVE_4;
				break;
			case 132:
				result = T.KEYBOARD_EFFECTIVE_3;
				break;
			case 142:
				result = T.KEYBOARD_EFFECTIVE_2;
				break;
			case 152:
				result = T.KEYBOARD_EFFECTIVE_1;
				break;
			case 162:
				result = T.KEYBOARD_EFFECTIVE_0;
				break;
			default:
				if (freq >= 522)
				{
					result = T.KEYBOARD_EFFECTIVE_NO;
				}
				break;
			}
			
		}
//		result |= T.KEYBOARD_EFFECTIVE_DEL;
//		result |= T.KEYBOARD_EFFECTIVE_CANCLE;
		return result;
	}

	@Override
	public int ProcKey_3(int freq, boolean bFM) {
		int result = 0;
		if (bFM)
		{
			switch (freq) {
			case 93:
			case 103:
				result = T.KEYBOARD_EFFECTIVE_ALL;
				break;
			case 1003:
			case 1013:
			case 1023:
			case 1033:
			case 1043:
			case 1053:
			case 1063:
			case 1073:
				result = T.KEYBOARD_EFFECTIVE_05;
				break;
			default:
				if (freq > 880 && freq < 1000)
				{
					result = T.KEYBOARD_EFFECTIVE_05;
				}
				else if (freq >= 8750)
				{
					result = T.KEYBOARD_EFFECTIVE_NO;
				}
					break;
			}
//			result |= T.KEYBOARD_EFFECTIVE_OK;
		}
		else
		{
			switch (freq) {
			case 13:
				result = T.KEYBOARD_EFFECTIVE_ALL;
				break;
			case 53:
				result = T.KEYBOARD_EFFECTIVE_1;
				break;
			case 63:
				result = T.KEYBOARD_EFFECTIVE_09;
				break;
			case 73:
				result = T.KEYBOARD_EFFECTIVE_8;
				break;
			case 83:
				result = T.KEYBOARD_EFFECTIVE_7;
				break;
			case 93:
				result = T.KEYBOARD_EFFECTIVE_6;
				break;
			case 103:
				result = T.KEYBOARD_EFFECTIVE_5;
				break;
			case 113:
				result = T.KEYBOARD_EFFECTIVE_4;
				break;
			case 123:
				result = T.KEYBOARD_EFFECTIVE_3;
				break;
			case 133:
				result = T.KEYBOARD_EFFECTIVE_2;
				break;
			case 143:
				result = T.KEYBOARD_EFFECTIVE_1;
				break;
			case 153:
				result = T.KEYBOARD_EFFECTIVE_09;
				break;
			default:
				if (freq >= 603)
				{
					result = T.KEYBOARD_EFFECTIVE_NO;
				}
				break;
			}
			
		}
//		result |= T.KEYBOARD_EFFECTIVE_DEL;
//		result |= T.KEYBOARD_EFFECTIVE_CANCLE;
		return result;
	}

	@Override
	public int ProcKey_4(int freq, boolean bFM) {
		int result = 0;
		if (bFM)
		{
			switch (freq) {
			case 94:
			case 104:
				result = T.KEYBOARD_EFFECTIVE_ALL;
				break;
			case 1004:
			case 1014:
			case 1024:
			case 1034:
			case 1044:
			case 1054:
			case 1064:
			case 1074:
				result = T.KEYBOARD_EFFECTIVE_05;
				break;
			default:
				if (freq > 880 && freq < 1000)
				{
					result = T.KEYBOARD_EFFECTIVE_05;
				}
				else if (freq >= 8750)
				{
					result = T.KEYBOARD_EFFECTIVE_NO;
				}
					break;
			}
//			result |= T.KEYBOARD_EFFECTIVE_OK;
		}
		else
		{
			switch (freq) {
			case 14:
				result = T.KEYBOARD_EFFECTIVE_ALL;
				break;
			case 54:
				result = T.KEYBOARD_EFFECTIVE_09;
				break;
			case 64:
				result = T.KEYBOARD_EFFECTIVE_8;
				break;
			case 74:
				result = T.KEYBOARD_EFFECTIVE_7;
				break;
			case 84:
				result = T.KEYBOARD_EFFECTIVE_6;
				break;
			case 94:
				result = T.KEYBOARD_EFFECTIVE_5;
				break;
			case 104:
				result = T.KEYBOARD_EFFECTIVE_4;
				break;
			case 114:
				result = T.KEYBOARD_EFFECTIVE_3;
				break;
			case 124:
				result = T.KEYBOARD_EFFECTIVE_2;
				break;
			case 134:
				result = T.KEYBOARD_EFFECTIVE_1;
				break;
			case 144:
				result = T.KEYBOARD_EFFECTIVE_09;
				break;
			case 154:
				result = T.KEYBOARD_EFFECTIVE_8;
				break;
			default:
				if (freq >= 594)
				{
					result = T.KEYBOARD_EFFECTIVE_NO;
				}
				break;
			}
			
		}
//		result |= T.KEYBOARD_EFFECTIVE_DEL;
//		result |= T.KEYBOARD_EFFECTIVE_CANCLE;
		return result;
	}

	@Override
	public int ProcKey_5(int freq, boolean bFM) {
		int result = 0;
		if (bFM)
		{
			switch (freq) {
			case 95:
			case 105:
				result = T.KEYBOARD_EFFECTIVE_ALL;
				break;
			case 1005:
			case 1015:
			case 1025:
			case 1035:
			case 1045:
			case 1055:
			case 1065:
			case 1075:
				result = T.KEYBOARD_EFFECTIVE_05;
				break;
			default:
				if (freq >= 875 && freq < 1000)
				{
					result = T.KEYBOARD_EFFECTIVE_05;
				}
				else if (freq >= 8750)
				{
					result = T.KEYBOARD_EFFECTIVE_NO;
				}
					break;
			}
//			result |= T.KEYBOARD_EFFECTIVE_OK;
		}
		else
		{
			switch (freq) {
			case 5:
				result = T.KEYBOARD_EFFECTIVE_2_9;
				break;
			case 15:
				result = T.KEYBOARD_EFFECTIVE_ALL;
				break;
			case 55:
				result = T.KEYBOARD_EFFECTIVE_8;
				break;
			case 65:
				result = T.KEYBOARD_EFFECTIVE_7;
				break;
			case 75:
				result = T.KEYBOARD_EFFECTIVE_6;
				break;
			case 85:
				result = T.KEYBOARD_EFFECTIVE_5;
				break;
			case 95:
				result = T.KEYBOARD_EFFECTIVE_4;
				break;
			case 105:
				result = T.KEYBOARD_EFFECTIVE_3;
				break;
			case 115:
				result = T.KEYBOARD_EFFECTIVE_2;
				break;
			case 125:
				result = T.KEYBOARD_EFFECTIVE_1;
				break;
			case 135:
				result = T.KEYBOARD_EFFECTIVE_09;
				break;
			case 145:
				result = T.KEYBOARD_EFFECTIVE_8;
				break;
			case 155:
				result = T.KEYBOARD_EFFECTIVE_7;
				break;
			default:
				if (freq >= 585)
				{
					result = T.KEYBOARD_EFFECTIVE_NO;
				}
				break;
			}
			
		}
//		result |= T.KEYBOARD_EFFECTIVE_DEL;
//		result |= T.KEYBOARD_EFFECTIVE_CANCLE;
		return result;
	}

	@Override
	public int ProcKey_6(int freq, boolean bFM) {
		int result = 0;
		if (bFM)
		{
			switch (freq) {
			case 96:
			case 106:
				result = T.KEYBOARD_EFFECTIVE_ALL;
				break;
			case 1006:
			case 1016:
			case 1026:
			case 1036:
			case 1046:
			case 1056:
			case 1066:
			case 1076:
				result = T.KEYBOARD_EFFECTIVE_05;
				break;
			default:
				if (freq >= 875 && freq < 1000)
				{
					result = T.KEYBOARD_EFFECTIVE_05;
				}
				else if (freq >= 8750)
				{
					result = T.KEYBOARD_EFFECTIVE_NO;
				}
					break;
			}
//			result |= T.KEYBOARD_EFFECTIVE_OK;
		}
		else
		{
			switch (freq) {
			case 6:
				result = T.KEYBOARD_EFFECTIVE_ALL;
				break;
			case 16:
				result = T.KEYBOARD_EFFECTIVE_0_2;
				break;
			case 56:
				result = T.KEYBOARD_EFFECTIVE_7;
				break;
			case 66:
				result = T.KEYBOARD_EFFECTIVE_6;
				break;
			case 76:
				result = T.KEYBOARD_EFFECTIVE_5;
				break;
			case 86:
				result = T.KEYBOARD_EFFECTIVE_4;
				break;
			case 96:
				result = T.KEYBOARD_EFFECTIVE_3;
				break;
			case 106:
				result = T.KEYBOARD_EFFECTIVE_2;
				break;
			case 116:
				result = T.KEYBOARD_EFFECTIVE_1;
				break;
			case 126:
				result = T.KEYBOARD_EFFECTIVE_09;
				break;
			case 136:
				result = T.KEYBOARD_EFFECTIVE_8;
				break;
			case 146:
				result = T.KEYBOARD_EFFECTIVE_7;
				break;
			case 156:
				result = T.KEYBOARD_EFFECTIVE_6;
				break;
			default:
				if (freq >= 576)
				{
					result = T.KEYBOARD_EFFECTIVE_NO;
				}
				break;
			}
			
		}
//		result |= T.KEYBOARD_EFFECTIVE_DEL;
//		result |= T.KEYBOARD_EFFECTIVE_CANCLE;
		return result;
	}

	@Override
	public int ProcKey_7(int freq, boolean bFM) {


		int result = 0;
		if (bFM)
		{
			switch (freq) {
			case 87:
				result = T.KEYBOARD_EFFECTIVE_5_9;
				break;
			case 97:
			case 107:
				result = T.KEYBOARD_EFFECTIVE_ALL;
				break;
			case 1007:
			case 1017:
			case 1027:
			case 1037:
			case 1047:
			case 1057:
			case 1067:
			case 1077:
				result = T.KEYBOARD_EFFECTIVE_05;
				break;
			default:
				if (freq >= 875 && freq < 1000)
				{
					result = T.KEYBOARD_EFFECTIVE_05;
				}
				else if (freq >= 8750)
				{
					result = T.KEYBOARD_EFFECTIVE_NO;
				}
					break;
			}
//			result |= T.KEYBOARD_EFFECTIVE_OK;
		}
		else
		{
			switch (freq) {
			case 7:
				result = T.KEYBOARD_EFFECTIVE_ALL;
				break;
			case 57:
				result = T.KEYBOARD_EFFECTIVE_6;
				break;
			case 67:
				result = T.KEYBOARD_EFFECTIVE_5;
				break;
			case 77:
				result = T.KEYBOARD_EFFECTIVE_4;
				break;
			case 87:
				result = T.KEYBOARD_EFFECTIVE_3;
				break;
			case 97:
				result = T.KEYBOARD_EFFECTIVE_2;
				break;
			case 107:
				result = T.KEYBOARD_EFFECTIVE_1;
				break;
			case 117:
				result = T.KEYBOARD_EFFECTIVE_09;
				break;
			case 127:
				result = T.KEYBOARD_EFFECTIVE_8;
				break;
			case 137:
				result = T.KEYBOARD_EFFECTIVE_7;
				break;
			case 147:
				result = T.KEYBOARD_EFFECTIVE_6;
				break;
			case 157:
				result = T.KEYBOARD_EFFECTIVE_5;
				break;
			default:
				if (freq >= 567)
				{
					result = T.KEYBOARD_EFFECTIVE_NO;
				}
				break;
			}
			
		}
//		result |= T.KEYBOARD_EFFECTIVE_DEL;
//		result |= T.KEYBOARD_EFFECTIVE_CANCLE;
		return result;
	}

	@Override
	public int ProcKey_8(int freq, boolean bFM) {
		int result = 0;
		if (bFM)
		{
			switch (freq) {
			case 8:
				result = T.KEYBOARD_EFFECTIVE_7_9;
				break;
			case 88:
			case 98:
				result = T.KEYBOARD_EFFECTIVE_ALL;
				break;
			case 108:
				result = T.KEYBOARD_EFFECTIVE_0;
				break;
			case 1008:
			case 1018:
			case 1028:
			case 1038:
			case 1048:
			case 1058:
			case 1068:
			case 1078:
				result = T.KEYBOARD_EFFECTIVE_05;
				break;
			default:
				if (freq >= 875 && freq < 1000)
				{
					result = T.KEYBOARD_EFFECTIVE_05;
				}
				else if (freq >= 8750)
				{
					result = T.KEYBOARD_EFFECTIVE_NO;
				}
					break;
			}
//			result |= T.KEYBOARD_EFFECTIVE_OK;
		}
		else
		{
			switch (freq) {
			case 8:
				result = T.KEYBOARD_EFFECTIVE_ALL;
				break;
			case 58:
				result = T.KEYBOARD_EFFECTIVE_5;
				break;
			case 68:
				result = T.KEYBOARD_EFFECTIVE_4;
				break;
			case 78:
				result = T.KEYBOARD_EFFECTIVE_3;
				break;
			case 88:
				result = T.KEYBOARD_EFFECTIVE_2;
				break;
			case 98:
				result = T.KEYBOARD_EFFECTIVE_1;
				break;
			case 108:
				result = T.KEYBOARD_EFFECTIVE_09;
				break;
			case 118:
				result = T.KEYBOARD_EFFECTIVE_8;
				break;
			case 128:
				result = T.KEYBOARD_EFFECTIVE_7;
				break;
			case 138:
				result = T.KEYBOARD_EFFECTIVE_6;
				break;
			case 148:
				result = T.KEYBOARD_EFFECTIVE_5;
				break;
			case 158:
				result = T.KEYBOARD_EFFECTIVE_4;
				break;
			default:
				if (freq >= 558)
				{
					result = T.KEYBOARD_EFFECTIVE_NO;
				}
				break;
			}
			
		}
//		result |= T.KEYBOARD_EFFECTIVE_DEL;
//		result |= T.KEYBOARD_EFFECTIVE_CANCLE;
		return result;
	}

	@Override
	public int ProcKey_9(int freq, boolean bFM) {
		int result = 0;
		if (bFM)
		{
			switch (freq) {
			case 9:
			case 89:
			case 99:
				result = T.KEYBOARD_EFFECTIVE_ALL;
				break;
			case 1009:
			case 1019:
			case 1029:
			case 1039:
			case 1049:
			case 1059:
			case 1069:
			case 1079:
				result = T.KEYBOARD_EFFECTIVE_05;
				break;
			default:
				if (freq >= 875 && freq < 1000)
				{
					result = T.KEYBOARD_EFFECTIVE_05;
				}
				else if (freq >= 8750)
				{
					result = T.KEYBOARD_EFFECTIVE_NO;
				}
					break;
			}
//			result |= T.KEYBOARD_EFFECTIVE_OK;
		}
		else
		{
			switch (freq) {
			case 9:
				result = T.KEYBOARD_EFFECTIVE_ALL;
				break;
			case 59:
				result = T.KEYBOARD_EFFECTIVE_4;
				break;
			case 69:
				result = T.KEYBOARD_EFFECTIVE_3;
				break;
			case 79:
				result = T.KEYBOARD_EFFECTIVE_2;
				break;
			case 89:
				result = T.KEYBOARD_EFFECTIVE_1;
				break;
			case 99:
				result = T.KEYBOARD_EFFECTIVE_09;
				break;
			case 109:
				result = T.KEYBOARD_EFFECTIVE_8;
				break;
			case 119:
				result = T.KEYBOARD_EFFECTIVE_7;
				break;
			case 129:
				result = T.KEYBOARD_EFFECTIVE_6;
				break;
			case 139:
				result = T.KEYBOARD_EFFECTIVE_5;
				break;
			case 149:
				result = T.KEYBOARD_EFFECTIVE_4;
				break;
			case 159:
				result = T.KEYBOARD_EFFECTIVE_3;
				break;
			default:
				if (freq >= 549)
				{
					result = T.KEYBOARD_EFFECTIVE_NO;
				}
				break;
			}
			
		}
//		result |= T.KEYBOARD_EFFECTIVE_DEL;
//		result |= T.KEYBOARD_EFFECTIVE_CANCLE;
		return result;
	}

	@Override
	public int ProcKey_del(int freq, boolean bFM) {
		int result = 0;
		if (bFM)
		{
			switch (freq) {
			case 0:
				result = T.KEYBOARD_EFFECTIVE_189;
				break;
			case 1:
				result = T.KEYBOARD_EFFECTIVE_0;
				break;
			case 8:
				result = T.KEYBOARD_EFFECTIVE_7_9;
				break;
			case 9:
				result = T.KEYBOARD_EFFECTIVE_ALL;
				break;
			case 10:
				result = T.KEYBOARD_EFFECTIVE_0_8;
				break;
			case 87:
				result = T.KEYBOARD_EFFECTIVE_5_9;
				break;
			case 108:
			case 1080:
				result = T.KEYBOARD_EFFECTIVE_0;
				break;
			default:
				if (freq >= 88 && freq < 108)
				{
					result = T.KEYBOARD_EFFECTIVE_ALL;
				}
				else if (freq >= 875 && freq < 1080)
				{
					result = T.KEYBOARD_EFFECTIVE_05;
				}
				break;
			}
//			result |= T.KEYBOARD_EFFECTIVE_OK;
		}
		else
		{
			switch (freq) {
			case 0:
				result = T.KEYBOARD_EFFECTIVE_15_9;
				break;
			case 1:
				result = T.KEYBOARD_EFFECTIVE_0_6;
				break;
			case 5:
				result = T.KEYBOARD_EFFECTIVE_2_9;
				break;
			case 16:
				result = T.KEYBOARD_EFFECTIVE_0_2;
				break;
			case 162:
				result = T.KEYBOARD_EFFECTIVE_0;
				break;
			default:
				if (freq >= 6 && freq < 16)
				{
					result = T.KEYBOARD_EFFECTIVE_ALL;
				}
				else if (freq >= 52 && freq < 162)
				{
					int sum = freq/100 + freq/10 + freq%10;
					switch (sum) {
					case 0:
					case 9:
						result = T.KEYBOARD_EFFECTIVE_09;
						break;
					case 1:
						result = T.KEYBOARD_EFFECTIVE_8;
						break;
					case 2:
						result = T.KEYBOARD_EFFECTIVE_7;
						break;
					case 3:
						result = T.KEYBOARD_EFFECTIVE_6;
						break;
					case 4:
						result = T.KEYBOARD_EFFECTIVE_5;
						break;
					case 5:
						result = T.KEYBOARD_EFFECTIVE_4;
						break;
					case 6:
						result = T.KEYBOARD_EFFECTIVE_3;
						break;
					case 7:
						result = T.KEYBOARD_EFFECTIVE_2;
						break;
					case 8:
						result = T.KEYBOARD_EFFECTIVE_1;
						break;
					}
				}
				break;
			}
			
		}
//		result &= ~T.KEYBOARD_EFFECTIVE_DEL;
//		result |= T.KEYBOARD_EFFECTIVE_CANCLE;
		return result;
	}

	@Override
	public int ProcKey_del_all(int freq, boolean bFM) {
		int result = 0;
		if (bFM)
		{
			result = T.KEYBOARD_EFFECTIVE_189;
		}
		else
		{
			result = T.KEYBOARD_EFFECTIVE_15_9;
		}
		result &= ~T.KEYBOARD_EFFECTIVE_DEL;
		result |= T.KEYBOARD_EFFECTIVE_CANCLE;
		result |= T.KEYBOARD_EFFECTIVE_OK;
		return result;
	}

	@Override
	public int ProcKey_confirm(int freq, boolean bFM) {
		int result = 0;
		if (bFM)
		{
			if (freq == 1)
			{
				result = 10000;
			}
			else if (freq  == 8 || freq == 87)
			{
				result = 8750;
			}
			else if (freq  == 9 || freq == 10)
			{
				result = freq*1000;
			}
			else if (freq  >= 88 && freq <= 108)
			{
				result = freq*100;
			}
			else if (freq  >= 875 && freq <= 1080)
			{
				result = freq*10;
			}
		}
		else
		{
			result = freq;
		}
		return result;
	}

}
