package org.jruby.puma;

import org.jruby.Ruby;
import org.jruby.RubyClass;
import org.jruby.RubyModule;
import org.jruby.RubyObject;
import org.jruby.anno.JRubyMethod;
import org.jruby.runtime.ObjectAllocator;
import org.jruby.runtime.ThreadContext;
import org.jruby.runtime.builtin.IRubyObject;

public class MiniSSL extends RubyObject {
	private static final long serialVersionUID = -3906672121787060013L;

	public static void createMiniSSLUnder(Ruby runtime, RubyModule mPuma) {
		RubyModule mMiniSSL = mPuma.defineModuleUnder("MiniSSL");
		RubyClass cEngine = mMiniSSL.defineClassUnder("Engine",
				runtime.getObject(), ALLOCATOR);
		cEngine.defineAnnotatedMethods(MiniSSL.class);

		RubyClass scEngine = cEngine.getSingletonClass();
		scEngine.defineAnnotatedMethods(MiniSSL.class);

		mMiniSSL.defineClassUnder("SSLError",
				runtime.getClass("StandardError"),
				runtime.getClass("StandardError").getAllocator());
	}

	private static ObjectAllocator ALLOCATOR = new ObjectAllocator() {
		public IRubyObject allocate(Ruby runtime, RubyClass klass) {
			return new MiniSSL(runtime, klass);
		}
	};

	public MiniSSL(Ruby runtime, RubyClass klass) {
		super(runtime, klass);
	}

	@JRubyMethod(meta = true)
	public static IRubyObject server(ThreadContext context, IRubyObject recv,
			IRubyObject key, IRubyObject cert) {
		return null;
	}

	@JRubyMethod(meta = true)
	public static IRubyObject client(ThreadContext context, IRubyObject recv) {
		return null;
	}

	@JRubyMethod
	public IRubyObject inject(IRubyObject str) {
		return null;
	}

	@JRubyMethod
	public IRubyObject read() {
		return null;
	}

	@JRubyMethod
	public IRubyObject write(IRubyObject str) {
		return null;
	}

	@JRubyMethod
	public IRubyObject extract() {
		return null;
	}
}
