import groovy.json.JsonSlurper
import groovy.xml.MarkupBuilder;

def writerHtml = new FileWriter ( './result.html')
def writerXml = new FileWriter('./result.xml')

def html = new MarkupBuilder(writerHtml)
def xml = new MarkupBuilder(writerXml)

def obj = new JsonSlurper().parse(new File('./test.json'))
println(obj.name)

html.div {
    div {
        id('employee') {
            p(obj.name)
            br {}
            p(obj.age)
            br {}
            p(obj.secretIdentity)
            br {}
            ul('powers') {
                li(obj.powers)
            }
        }
    }
}

xml.employee {
    name (obj.name)
    age (obj.age)
    secretIdentity (obj.secretIdentity)
    powers () {
        power (obj.powers)
    }
}

/**
 * <employee>
    <name>name</p><br/>
    <age>age</p><br/>
    <secretIdentity>secretIdentity</secretIdentity><br/>
    <powers>
        <power>powerName</power>
    < /powers>
 </employee>
 */