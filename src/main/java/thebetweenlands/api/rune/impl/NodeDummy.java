package thebetweenlands.api.rune.impl;

import java.util.List;

import com.google.common.collect.ImmutableList;

import thebetweenlands.api.rune.INode;
import thebetweenlands.api.rune.INodeBlueprint;
import thebetweenlands.api.rune.INodeComposition;
import thebetweenlands.api.rune.INodeConfiguration;
import thebetweenlands.api.rune.impl.RuneChainComposition.RuneExecutionContext;

public final class NodeDummy implements INode<NodeDummy, RuneExecutionContext> {

	public static final class Blueprint implements INodeBlueprint<NodeDummy, RuneExecutionContext> {
		public static final Blueprint INSTANCE = new Blueprint();

		public static final INodeConfiguration CONFIGURATION;

		static {
			PortNodeConfiguration.Builder builder = PortNodeConfiguration.builder();
			CONFIGURATION = builder.build();
		}

		private Blueprint() {}

		@Override
		public List<INodeConfiguration> getConfigurations() {
			return ImmutableList.of(CONFIGURATION);
		}

		@Override
		public NodeDummy create(INodeComposition<RuneExecutionContext> composition, INodeConfiguration configuration) {
			return new NodeDummy(this, composition, configuration);
		}

		@Override
		public void run(NodeDummy state, RuneExecutionContext executor, INodeIO io) {
			io.fail();
		}

		@Override
		public void fail(NodeDummy state, RuneExecutionContext executor) {

		}

		@Override
		public void terminate(NodeDummy state, RuneExecutionContext context) {

		}
	}

	private final Blueprint blueprint;
	private final INodeComposition<RuneExecutionContext> composition;
	private final INodeConfiguration configuration;

	private NodeDummy(Blueprint blueprint, INodeComposition<RuneExecutionContext> composition, INodeConfiguration configuration) {
		this.blueprint = blueprint;
		this.composition = composition;
		this.configuration = configuration;
	}

	@Override
	public INodeBlueprint<NodeDummy, RuneExecutionContext> getBlueprint() {
		return this.blueprint;
	}

	@Override
	public INodeConfiguration getConfiguration() {
		return this.configuration;
	}

	@Override
	public INodeComposition<RuneExecutionContext> getComposition() {
		return this.composition;
	}
}
