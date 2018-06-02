import groovy.text.markup.*

def template = new MarkupTemplateEngine(new TemplateConfiguration()).createTemplate('''
    html {
        head {
            title(pageTitle)
        }
        body {
            h1(pageTitle)
        }
    }
''')

def model = [pageTitle:"Hello, World!"]

template.make(model).writeTo(new PrintWriter(System.out))