//
//  SourcesScreen.swift
//  iosApp
//
//  Created by Pavel Kharlamov on 01.04.2025.
//  Copyright © 2025 orgName. All rights reserved.
//

import SwiftUI
import shared

extension SourcesScreen {
    
    @MainActor
    class SourcesViewModelWrapper: ObservableObject {
        let sourcesViewModel: SourcesViewModel
        
        init() {
            sourcesViewModel = SourcesInjector().sourcesViewModel
            sourcesState = sourcesViewModel.sourcesState.value
        }
        
        @Published var sourcesState: SourcesState
        
        func startObserving() {
            Task {
                for await sources in sourcesViewModel.sourcesState {
                    self.sourcesState = sources
                }
            }
        }
    }
}

struct SourcesScreen: View {
    @Environment(\.dismiss)
    private var dismiss
    
    @ObservedObject private(set) var viewModel: SourcesViewModelWrapper
    
    var body: some View {
        NavigationStack {
            sourceListView()
                .navigationTitle("Sources")
                .toolbar {
                    ToolbarItem(placement: .primaryAction) {
                        Button {
                            dismiss()
                        } label: {
                            Text("Done")
                                .bold()
                        }
                    }
                }
        }
    }
    
    @ViewBuilder func sourceListView() -> some View {
        VStack {
            if viewModel.sourcesState.loading {
                Loader()
            }
            
            if let error = viewModel.sourcesState.error {
                ErrorMessage(message: error)
            }
            
            if (!viewModel.sourcesState.sources.isEmpty) {
                ScrollView {
                    LazyVStack(spacing: 10) {
                        ForEach(viewModel.sourcesState.sources, id: \.self) { source in
                            SourceItemView(source: source)
                        }
                    }
                }
            }
        }
        .onAppear {
            self.viewModel.startObserving()
        }
    }
}

struct SourceItemView: View {
    var source: Source
    
    var body: some View {
        VStack(alignment: .leading, spacing: 8) {
            Text(source.title)
                .font(.title)
                .fontWeight(.bold)
            Text(source.desc)
            Text(source.country + " - " + source.language).frame(maxWidth: .infinity, alignment: .trailing).foregroundStyle(.gray)
                .padding(.bottom, 10)
            Divider()
        }
        .padding(16)
    }
}
