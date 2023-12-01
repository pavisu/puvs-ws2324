/*const { Resource } = require('@opentelemetry/resources');

const { SemanticResourceAttributes } = require('@opentelemetry/semantic-conventions');

const { WebTracerProvider, SimpleSpanProcessor, ConsoleSpanExporter } = require('@opentelemetry/sdk-trace-web');

const { OTLPTraceExporter }  = require('@opentelemetry/exporter-trace-otlp-http');

const { registerInstrumentations } = require('@opentelemetry/instrumentation');

const { FetchInstrumentation } = require('@opentelemetry/instrumentation-fetch');

const consoleExporter = new ConsoleSpanExporter();

const collectorExporter = new OTLPTraceExporter({

  headers: {}

});

const provider = new WebTracerProvider({

  resource: new Resource({

    [SemanticResourceAttributes.SERVICE_NAME]: process.env.REACT_APP_NAME

  })

});

const fetchInstrumentation = new FetchInstrumentation({});

fetchInstrumentation.setTracerProvider(provider);

provider.addSpanProcessor(new SimpleSpanProcessor(consoleExporter));

provider.addSpanProcessor(new SimpleSpanProcessor(collectorExporter));

provider.register();

registerInstrumentations({

  instrumentations: [

    fetchInstrumentation

  ],

  tracerProvider: provider

});

export default function TraceProvider ({ children }) {

  return (

   <>

      {children}

   </>

  );

}
*/

/* document-load.ts|js file - the code is the same for both the languages */
import { SimpleSpanProcessor } from '@opentelemetry/sdk-trace-base';
import { WebTracerProvider } from '@opentelemetry/sdk-trace-web';
import { DocumentLoadInstrumentation } from '@opentelemetry/instrumentation-document-load';
import { ZoneContextManager } from '@opentelemetry/context-zone';
import { OTLPTraceExporter } from '@opentelemetry/exporter-trace-otlp-proto';
import { registerInstrumentations } from '@opentelemetry/instrumentation';

const provider = new WebTracerProvider();
const traceExporter = new OTLPTraceExporter({
    // optional - default url is http://localhost:4318/v1/traces
    url: 'https://4318-pavisu-puvsws2324-wxiku9m0c0t.ws-eu106.gitpod.io/v1/traces',
    // optional - collection of custom headers to be sent with each request, empty by default
    headers: {},
})

//provider.addSpanProcessor(new SimpleSpanProcessor(new ConsoleSpanExporter()));
provider.addSpanProcessor(new SimpleSpanProcessor(traceExporter));

provider.register({
    // Changing default contextManager to use ZoneContextManager - supports asynchronous operations - optional
    contextManager: new ZoneContextManager()
});

// Registering instrumentations
registerInstrumentations({
    instrumentations: [
        new DocumentLoadInstrumentation()
    ],
});
export default function TraceProvider({ children }) {
    return (
        <>
            {children}
        </>
    );
}