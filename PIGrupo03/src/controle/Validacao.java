package controle;

public class Validacao {
	public static boolean verificaInt(String n) {
		boolean ret;
		try {
		Integer.parseInt(n);
		ret = true;
		}
		catch (Exception e){
			ret = false;
		}
		return ret;
	}
}
